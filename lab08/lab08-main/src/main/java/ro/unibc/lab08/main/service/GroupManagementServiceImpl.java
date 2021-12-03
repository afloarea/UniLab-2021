package ro.unibc.lab08.main.service;

import org.springframework.stereotype.Service;
import ro.unibc.lab08.main.dao.GroupDao;
import ro.unibc.lab08.main.dao.StudentDao;
import ro.unibc.lab08.main.dto.*;
import ro.unibc.lab08.main.model.Student;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Transactional
@Service
public class GroupManagementServiceImpl implements GroupManagementService {

    private final GroupDao groupDao;
    private final StudentDao studentDao;

    public GroupManagementServiceImpl(GroupDao groupDao, StudentDao studentDao) {
        this.groupDao = groupDao;
        this.studentDao = studentDao;
    }

    @Override
    public CreateGroupResponse createGroup(CreateGroupRequest request) {
        final var savedGroup = groupDao.insert(request.name());
        return new CreateGroupResponse(savedGroup.getId(), savedGroup.getName());
    }

    @Override
    public List<GroupEntry> getAllGroups() {
        return groupDao.findAll().stream()
                .map(group -> new GroupEntry(
                        group.getId(),
                        group.getName(),
                        group.getGroupLeader() == null ? null : group.getGroupLeader().getName()))
                .toList();
    }

    @Override
    public StudentEntry addStudentToGroup(long groupId, AddStudentRequest request) {
        final var group = groupDao.findById(groupId);
        if (group == null) {
            throw new NoSuchElementException("No group with id %d found".formatted(groupId));
        }

        final var student = new Student();
        student.setName(request.name());
        student.setGroup(group);

        final var savedStudent = studentDao.save(student);
        return new StudentEntry(savedStudent.getId(), savedStudent.getName());
    }

    @Override
    public List<StudentEntry> getStudentsForGroupId(long groupId) {
        final var group = groupDao.findById(groupId);
        if (group == null) {
            return Collections.emptyList();
        }
        return group.getStudents().stream()
                .map(student -> new StudentEntry(student.getId(), student.getName()))
                .toList();
    }

    @Override
    public void updateGroupLeader(long groupId, long studentId) {
        final var group = groupDao.findById(groupId);
        if (group == null) {
            System.out.println("No group found");
            return;
        }

        final var student = studentDao.findById(studentId);
        if (student == null) {
            System.out.println("No student found");
            return;
        }

        group.setGroupLeader(student);
        groupDao.update(group);
    }

    @Override
    public void removeStudentFromGroup(long groupId, long studentId) {
        final var student = studentDao.findByIdAndGroupId(studentId, groupId);
        final var group = student.getGroup();
        if (group.getGroupLeader().getId() == student.getId()) {
            group.setGroupLeader(null);
            groupDao.update(group);
        }

        studentDao.delete(student);
    }
}
