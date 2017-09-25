package com.rajbir.core.dto;

import java.util.List;

/**
 * Created by Sony on 25-09-2017.
 */
public class GroupDto {
    private Long groupId;
    private String groupName;
    private List<String> userIds;
    private List<Long> postIds;

    public GroupDto() {
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

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

    public List<Long> getPostIds() {
        return postIds;
    }

    public void setPostIds(List<Long> postIds) {
        this.postIds = postIds;
    }

    public GroupDto(Long groupId, String groupName, List<String> userIds, List<Long> postIds) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.userIds = userIds;
        this.postIds = postIds;
    }

    public static interface GroupIdStep {
        GroupNameStep withGroupId(Long groupId);
    }

    public static interface GroupNameStep {
        UserIdsStep withGroupName(String groupName);
    }

    public static interface UserIdsStep {
        PostIdsStep withUserIds(List<String> userIds);
    }

    public static interface PostIdsStep {
        BuildStep withPostIds(List<Long> postIds);
    }

    public static interface BuildStep {
        GroupDto build();
    }


    public static class Builder implements GroupIdStep, GroupNameStep, UserIdsStep, PostIdsStep, BuildStep {
        private Long groupId;
        private String groupName;
        private List<String> userIds;
        private List<Long> postIds;

        public Builder() {
        }

        public static GroupIdStep groupDto() {
            return new Builder();
        }

        @Override
        public GroupNameStep withGroupId(Long groupId) {
            this.groupId = groupId;
            return this;
        }

        @Override
        public UserIdsStep withGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        @Override
        public PostIdsStep withUserIds(List<String> userIds) {
            this.userIds = userIds;
            return this;
        }

        @Override
        public BuildStep withPostIds(List<Long> postIds) {
            this.postIds = postIds;
            return this;
        }

        @Override
        public GroupDto build() {
            return new GroupDto(
                    this.groupId,
                    this.groupName,
                    this.userIds,
                    this.postIds
            );
        }
    }
}
