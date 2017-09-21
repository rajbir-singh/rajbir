package com.rajbir.core.dto;

import com.rajbir.core.domain.Group;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Sony on 08-09-2017.
 */
public class UserDto {

    @NotNull
    private String userId;

    @NotNull
//    @Column(length = 100)
    private String name;

    @Email(message = "{email.valid}")
//    @Column(nullable = false, length = 100)
    private String email;

//    @Column(length = 100)
    private String mobile;

    @Size(min = 2, max = 30, message = "{password.size}") //    The @Size annotation has message set to a string whose value is wrapped in curly braces. If you left the curly braces out, the value given to message would be the error message displayed to the user. But by using curly braces, you design at a property in a properties file that contains the actual message.
//    @Column(length = 100)
    private String password;

    private List<Group> groups;

    private String aboutMe;

    public UserDto() {
    }

    public UserDto(String userId, String name, String email, String mobile, String password, List<Group> groups, String aboutMe) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.password = password;
        this.groups = groups;
        this.aboutMe = aboutMe;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public static interface UserIdStep {
        NameStep withUserId(String userId);
    }

    public static interface NameStep {
        EmailStep withName(String name);
    }

    public static interface EmailStep {
        MobileStep withEmail(String email);
    }

    public static interface MobileStep {
        PasswordStep withMobile(String mobile);
    }

    public static interface PasswordStep {
        GroupsStep withPassword(String password);
    }

    public static interface GroupsStep {
        AboutMeStep withGroups(List<Group> groups);
    }

    public static interface AboutMeStep {
        BuildStep withAboutMe(String aboutMe);
    }

    public static interface BuildStep {
        UserDto build();
    }


    public static class Builder implements UserIdStep, NameStep, EmailStep, MobileStep, PasswordStep, GroupsStep, AboutMeStep, BuildStep {
        private String userId;
        private String name;
        private String email;
        private String mobile;
        private String password;
        private List<Group> groups;
        private String aboutMe;

        private Builder() {
        }

        public static UserIdStep userDto() {
            return new Builder();
        }

        @Override
        public NameStep withUserId(String userId) {
            this.userId = userId;
            return this;
        }

        @Override
        public EmailStep withName(String name) {
            this.name = name;
            return this;
        }

        @Override
        public MobileStep withEmail(String email) {
            this.email = email;
            return this;
        }

        @Override
        public PasswordStep withMobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        @Override
        public GroupsStep withPassword(String password) {
            this.password = password;
            return this;
        }

        @Override
        public AboutMeStep withGroups(List<Group> groups) {
            this.groups = groups;
            return this;
        }

        @Override
        public BuildStep withAboutMe(String aboutMe) {
            this.aboutMe = aboutMe;
            return this;
        }

        @Override
        public UserDto build() {
            return new UserDto(
                    this.userId,
                    this.name,
                    this.email,
                    this.mobile,
                    this.password,
                    this.groups,
                    this.aboutMe
            );
        }
    }
}
