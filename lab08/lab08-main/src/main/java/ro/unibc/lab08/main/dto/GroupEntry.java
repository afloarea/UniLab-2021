package ro.unibc.lab08.main.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

public record GroupEntry(long groupId, String groupName, @JsonInclude(JsonInclude.Include.NON_NULL) String groupLeader) {
}
