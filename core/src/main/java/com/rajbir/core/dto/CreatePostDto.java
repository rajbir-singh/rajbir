package com.rajbir.core.dto;

/**
 * Created by Sony on 28-09-2017.
 */
public class CreatePostDto {

    private String message;
    private String userId;
    private Long groupId;

    public CreatePostDto() {
    }

    public CreatePostDto(String message, String userId, Long groupId) {
        this.message = message;
        this.userId = userId;
        this.groupId = groupId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public static interface MessageStep {
        UserIdStep withMessage(String message);
    }

    public static interface UserIdStep {
        GroupIdStep withUserId(String userId);
    }

    public static interface GroupIdStep {
        BuildStep withGroupId(Long groupId);
    }

    public static interface BuildStep {
        CreatePostDto build();
    }


    public static class Builder implements MessageStep, UserIdStep, GroupIdStep, BuildStep {
        private String message;
        private String userId;
        private Long groupId;

        private Builder() {
        }

        public static MessageStep createPostDto() {
            return new Builder();
        }

        @Override
        public UserIdStep withMessage(String message) {
            this.message = message;
            return this;
        }

        @Override
        public GroupIdStep withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public BuildStep withGroupId(Long groupId) {
            this.groupId = groupId;
            return this;
        }

        @Override
        public CreatePostDto build() {
            return new CreatePostDto(
                    this.message,
                    this.userId,
                    this.groupId
            );
        }
    }
}
