package com.rajbir.core.domain;

        import javax.validation.constraints.NotNull;
        import java.util.Date;

/**
 * Created by Sony on 30-08-2017.
 */
public class Post {
    private Long id;

    @NotNull
    private String message;

    //    @NotNull
    private Date time;

    private Double latitude;
    private Double longitude;

    public Post() {
    }

    public Post(Long id, String message, Date time, Double latitude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
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

        if (!id.equals(post.id)) return false;
        if (message != null ? !message.equals(post.message) : post.message != null) return false;
        if (time != null ? !time.equals(post.time) : post.time != null) return false;
        if (latitude != null ? !latitude.equals(post.latitude) : post.latitude != null) return false;
        return longitude != null ? longitude.equals(post.longitude) : post.longitude == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
        result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
        return result;
    }
}

