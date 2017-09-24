package com.rajbir.core.dto;

import java.util.List;

/**
 * Created by Sony on 23-09-2017.
 */
public class GroupSummaryDto {
    private Long groupId;
    private String groupName;
    private List<UserDto> users;
    private List<PostDto> posts;

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

    public List<UserDto> getUsers() {
        return users;
    }

    public void setUsers(List<UserDto> users) {
        this.users = users;
    }

    public List<PostDto> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDto> posts) {
        this.posts = posts;
    }

    public GroupSummaryDto(Long groupId, String groupName, List<UserDto> users, List<PostDto> posts) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.users = users;
        this.posts = posts;
    }

    public static interface GroupIdStep {
        GroupNameStep withGroupId(Long groupId);
    }

    public static interface GroupNameStep {
        UsersStep withGroupName(String groupName);
    }

    public static interface UsersStep {
        PostsStep withUsers(List<UserDto> users);
    }

    public static interface PostsStep {
        BuildStep withPosts(List<PostDto> posts);
    }

    public static interface BuildStep {
        GroupSummaryDto build();
    }


    public static class Builder implements GroupIdStep, GroupNameStep, UsersStep, PostsStep, BuildStep {
        private Long groupId;
        private String groupName;
        private List<UserDto> users;
        private List<PostDto> posts;

        public Builder() {
        }

        public static GroupIdStep groupSummaryDto() {
            return new Builder();
        }

        @Override
        public GroupNameStep withGroupId(Long groupId) {
            this.groupId = groupId;
            return this;
        }

        @Override
        public UsersStep withGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        @Override
        public PostsStep withUsers(List<UserDto> users) {
            this.users = users;
            return this;
        }

        @Override
        public BuildStep withPosts(List<PostDto> posts) {
            this.posts = posts;
            return this;
        }

        @Override
        public GroupSummaryDto build() {
            return new GroupSummaryDto(
                    this.groupId,
                    this.groupName,
                    this.users,
                    this.posts
            );
        }
    }
}
