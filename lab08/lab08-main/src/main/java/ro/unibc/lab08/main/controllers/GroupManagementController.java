package ro.unibc.lab08.main.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ro.unibc.lab08.main.dto.*;
import ro.unibc.lab08.main.service.GroupManagementService;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupManagementController {

    private final GroupManagementService gms;

    public GroupManagementController(GroupManagementService gms) {
        this.gms = gms;
    }

    @PostMapping
    public CreateGroupResponse createGroup(@RequestBody CreateGroupRequest request) {
        return gms.createGroup(request);
    }

    @GetMapping
    public List<GroupEntry> fetchGroups() {
        return gms.getAllGroups();
    }

    @PostMapping("/{groupId}/students")
    public StudentEntry addStudent(@PathVariable("groupId") long groupId, @RequestBody AddStudentRequest body) {
        return gms.addStudentToGroup(groupId, body);
    }

    @GetMapping("/{groupId}/students")
    public List<StudentEntry> listGroupStudents(@PathVariable("groupId") long groupId) {
        return gms.getStudentsForGroupId(groupId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{groupId}/students/{studentId}")
    public void updateGroupLeader(@PathVariable("groupId") long groupId, @PathVariable("studentId") long studentId) {
        gms.updateGroupLeader(groupId, studentId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{groupId}/students/{studentId}")
    public void removeStudentFromGroup(@PathVariable("groupId") long groupId, @PathVariable("studentId") long studentId) {
        gms.removeStudentFromGroup(groupId, studentId);
    }

}
