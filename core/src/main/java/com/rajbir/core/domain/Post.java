package com.rajbir.core.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * Created by Sony on 30-08-2017.
 */
@Entity(name = "post")
@Table(name = "post",
        indexes = {
                @Index(name = "index_postId", columnList = "postId")})

public class Post {

    @Id
    @GeneratedValue
    private Long postId;

    @NotNull
    private String message;

    //    @NotNull
    private Date time;

    private Double latitude;
    private Double longitude;

    public Post() {
    }

    public Post(Long postId, String message, Date time, Double latitude, Double longitude) {
        this.postId = postId;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getPostId() {
        return postId;
    }

    public String getMessage() {
        return message;
    }

    public Date getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Post post = (Post) o;

        if (postId != null ? !postId.equals(post.postId) : post.postId != null) return false;
        if (!message.equals(post.message)) return false;
        if (!time.equals(post.time)) return false;
        if (latitude != null ? !latitude.equals(post.latitude) : post.latitude != null) return false;
        return longitude != null ? longitude.equals(post.longitude) : post.longitude == null;

    }

    @Override
    public int hashCode() {
        int result = postId != null ? postId.hashCode() : 0;
        result = 31 * result + message.hashCode();
        result = 31 * result + time.hashCode();
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}

