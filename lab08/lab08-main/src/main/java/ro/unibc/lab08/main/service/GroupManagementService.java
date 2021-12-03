package ro.unibc.lab08.main.service;

import ro.unibc.lab08.main.dto.*;

import java.util.List;

public interface GroupManagementService {

    CreateGroupResponse createGroup(CreateGroupRequest request);

    List<GroupEntry> getAllGroups();

    StudentEntry addStudentToGroup(long groupId, AddStudentRequest request);

    List<StudentEntry> getStudentsForGroupId(long groupId);

    void updateGroupLeader(long groupId, long studentId);

    void removeStudentFromGroup(long groupId, long studentId);

}
