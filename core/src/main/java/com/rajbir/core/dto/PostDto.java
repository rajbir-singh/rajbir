package com.rajbir.core.dto;

/**
 * Created by Sony on 23-09-2017.
 */
public class PostDto {
    private Long postId;
    private String message;
    private Long time;
    private String byUserId;
    private String byUserName;
    private Long groupId;

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public String getByUserId() {
        return byUserId;
    }

    public void setByUserId(String byUserId) {
        this.byUserId = byUserId;
    }

    public String getByUserName() {
        return byUserName;
    }

    public void setByUserName(String byUserName) {
        this.byUserName = byUserName;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public PostDto(Long postId, String message, Long time, String byUserId, String byUserName, Long groupId) {
        this.postId = postId;
        this.message = message;
        this.time = time;
        this.byUserId = byUserId;
        this.byUserName = byUserName;
        this.groupId = groupId;
    }

    public static interface PostIdStep {
        MessageStep withPostId(Long postId);
    }

    public static interface MessageStep {
        TimeStep withMessage(String message);
    }

    public static interface TimeStep {
        ByUserIdStep withTime(Long time);
    }

    public static interface ByUserIdStep {
        ByUserNameStep withByUserId(String byUserId);
    }

    public static interface ByUserNameStep {
        GroupIdStep withByUserName(String byUserName);
    }

    public static interface GroupIdStep {
        BuildStep withGroupId(Long groupId);
    }

    public static interface BuildStep {
        PostDto build();
    }

    public static class Builder implements PostIdStep, MessageStep, TimeStep, ByUserIdStep, ByUserNameStep, GroupIdStep, BuildStep {
        private Long postId;
        private String message;
        private Long time;
        private String byUserId;
        private String byUserName;
        private Long groupId;

        public Builder() {
        }

        public static PostIdStep postDto() {
            return new Builder();
        }

        @Override
        public MessageStep withPostId(Long postId) {
            this.postId = postId;
            return this;
        }

        @Override
        public TimeStep withMessage(String message) {
            this.message = message;
            return this;
        }

        @Override
        public ByUserIdStep withTime(Long time) {
            this.time = time;
            return this;
        }

        @Override
        public ByUserNameStep withByUserId(String byUserId) {
            this.byUserId = byUserId;
            return this;
        }

        @Override
        public GroupIdStep withByUserName(String byUserName) {
            this.byUserName = byUserName;
            return this;
        }

        @Override
        public BuildStep withGroupId(Long groupId) {
            this.groupId = groupId;
            return this;
        }

        @Override
        public PostDto build() {
            return new PostDto(
                    this.postId,
                    this.message,
                    this.time,
                    this.byUserId,
                    this.byUserName,
                    this.groupId
            );
        }
    }
}
