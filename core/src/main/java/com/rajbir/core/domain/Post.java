package com.rajbir.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * Created by Sony on 30-08-2017.
 */
@Entity(name = "post")
@Table(name = "post",
        indexes = {
                @Index(name = "index_postId", columnList = "postId")})

public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(length = 100)
    private Long postId;

    @NotNull
    @Column(length = 512)
    private String message;

    @NotNull
    @Column(length = 100)
    private Long time;

    @NotNull
    @Column(length = 100)
    private String byUserId;

    @NotNull
    @Column(length = 100)
    private String byUserName;

    //unidirectional oneToMany mapping with posts, as of now I do need all posts of a group, not the other way around.
    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Group.class)
    @JoinColumn(name = "groupId", nullable = false, updatable = false)
    private Group group;

    //Hibernate requires no-args constructor
    public Post() {
    }

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Post(String message, Long time, String byUserId, String byUserName, Group group) {
        this.message = message;
        this.time = time;
        this.byUserId = byUserId;
        this.byUserName = byUserName;
        this.group = group;
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
        GroupStep withByUserName(String byUserName);
    }

    public static interface GroupStep {
        BuildStep withGroup(Group group);
    }

    public static interface BuildStep {
        Post build();
    }


    public static class Builder implements MessageStep, TimeStep, ByUserIdStep, ByUserNameStep, GroupStep, BuildStep {
        private String message;
        private Long time;
        private String byUserId;
        private String byUserName;
        private Group group;

        public Builder() {
        }

        public static MessageStep post() {
            return new Builder();
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
        public GroupStep withByUserName(String byUserName) {
            this.byUserName = byUserName;
            return this;
        }

        @Override
        public BuildStep withGroup(Group group) {
            this.group = group;
            return this;
        }

        @Override
        public Post build() {
            return new Post(
                    this.message,
                    this.time,
                    this.byUserId,
                    this.byUserName,
                    this.group
            );
        }
    }
}

