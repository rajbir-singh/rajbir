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

    public PostDto(Long postId, String message, Long time, String byUserId, String byUserName) {
        this.postId = postId;
        this.message = message;
        this.time = time;
        this.byUserId = byUserId;
        this.byUserName = byUserName;
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
        BuildStep withByUserName(String byUserName);
    }

    public static interface BuildStep {
        PostDto build();
    }


    public static class Builder implements PostIdStep, MessageStep, TimeStep, ByUserIdStep, ByUserNameStep, BuildStep {
        private Long postId;
        private String message;
        private Long time;
        private String byUserId;
        private String byUserName;

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
        public BuildStep withByUserName(String byUserName) {
            this.byUserName = byUserName;
            return this;
        }

        @Override
        public PostDto build() {
            return new PostDto(
                    this.postId,
                    this.message,
                    this.time,
                    this.byUserId,
                    this.byUserName
            );
        }
    }
}
