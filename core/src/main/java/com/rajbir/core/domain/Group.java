package com.rajbir.core.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by Sony on 08-09-2017.
 */
@Entity
@Table(name = "\"group\"", indexes = {@Index(name = "index_groupId", columnList = "groupId")})
public class Group {

    @Id
    @GeneratedValue
    @Column(length = 100)
    private Long groupId;

    @NotNull
    @Column(length = 100)
    private String groupName;

    //    @JoinColumn(referencedColumnName = "userId", name = "userId", nullable = false)
    @JoinTable(name = "group_users", joinColumns = {@JoinColumn(name = "groupId", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "userId", nullable = false, updatable = false)})
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, targetEntity = User.class)
    private List<User> users;

//    @JoinColumn(referencedColumnName = "postId", name="postId", nullable = false)
    //target entity : The entity class that is the target of the association. Optional only if the collection property is defined using Java generics. Must be specified otherwise.Defaults to the parameterized type of the collection when defined using generics.
    //cascade: (Optional) The operations that must be cascaded to the target of the association.Defaults to no operations being cascaded.
    //fetch : (Optional) Whether the association should be lazily loaded or must be eagerly fetched. The EAGER strategy is a requirement on the persistence provider runtime that the associated entities must be eagerly fetched. The LAZY strategy is a hint to the persistence provider runtime.
    //mappedBy : The field that owns the relationship. Required unless the relationship is unidirectional.
    //orhphanRemoval : (Optional) Whether to apply the remove operation to entities that have been removed from the relationship and to cascade the remove operation to those entities.

    //unidirectional oneToMany mapping with posts, as of now I do need all posts of a group, not the other way around.
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "group")
    private List<Post> posts;

    //Hibernate requires no-args constructor
    public Group() {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Group(String groupName, List<User> users, List<Post> posts) {
        this.groupName = groupName;
        this.users = users;
        this.posts = posts;
    }

    public static interface GroupNameStep {
        UsersStep withGroupName(String groupName);
    }

    public static interface UsersStep {
        PostsStep withUsers(List<User> users);
    }

    public static interface PostsStep {
        BuildStep withPosts(List<Post> posts);
    }

    public static interface BuildStep {
        Group build();
    }


    public static class Builder implements GroupNameStep, UsersStep, PostsStep, BuildStep {
        private String groupName;
        private List<User> users;
        private List<Post> posts;

        public Builder() {
        }

        public static GroupNameStep group() {
            return new Builder();
        }

        @Override
        public UsersStep withGroupName(String groupName) {
            this.groupName = groupName;
            return this;
        }

        @Override
        public PostsStep withUsers(List<User> users) {
            this.users = users;
            return this;
        }

        @Override
        public BuildStep withPosts(List<Post> posts) {
            this.posts = posts;
            return this;
        }

        @Override
        public Group build() {
            return new Group(
                    this.groupName,
                    this.users,
                    this.posts
            );
        }
    }
}
