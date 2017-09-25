package com.rajbir.core.dto;

import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

/**
 * Created by Sony on 23-09-2017.
 */
public class CreateGroupDto {

    @NotBlank(message = "group name can not be blank")
    private String groupName;

    private List<String> userIds;

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public CreateGroupDto(String groupName, List<String> userIds) {
        this.groupName = groupName;
        this.userIds = userIds;
    }

    public static interface GroupNameStep {
        UserIdsStep withGroupName(String groupName);
    }

    public static interface UserIdsStep {
        BuildStep withUserIds(List<String> userIds);
    }

    public static interface BuildStep {
        CreateGroupDto build();
    }

    public CreateGroupDto() {
    }

    public static class Builder implements GroupNameStep, UserIdsStep, BuildStep {
        private String groupName;
        private List<String> userIds;

        private Builder() {
        }

        public static GroupNameStep createGroupDto() {
            return new Builder();
        }

        @Override
        public UserIdsStep withGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        @Override
        public BuildStep withUserIds(List<String> userIds) {
            this.userIds = userIds;
            return this;
        }

        @Override
        public CreateGroupDto build() {
            return new CreateGroupDto(
                    this.groupName,
                    this.userIds
            );
        }
    }
}
