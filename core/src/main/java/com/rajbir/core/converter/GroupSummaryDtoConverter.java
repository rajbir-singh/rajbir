package com.rajbir.core.converter;

import com.rajbir.core.domain.Group;
import com.rajbir.core.domain.Post;
import com.rajbir.core.domain.User;
import com.rajbir.core.dto.GroupSummaryDto;
import com.rajbir.core.dto.PostDto;
import com.rajbir.core.dto.UserDto;
import com.rajbir.core.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 24-09-2017.
 */
@Component
public class GroupSummaryDtoConverter implements DtoConverter<Group, GroupSummaryDto>{

    @Autowired
    private UserDtoConverter userDtoConverter;

    @Autowired
    private PostDtoConverter postDtoConverter;

    @Override
    public GroupSummaryDto convertToDto(Group group) {
        if(Utils.isEmptyObject(group)) {
            return null;
        }

        List<User> userList = group.getUsers();
        List<UserDto> userDtos = new ArrayList<>();
        userList.forEach(user -> {
            userDtos.add(userDtoConverter.convertToDto(user));
        });


        List<Post> posts = group.getPosts();
        List<PostDto> postDtos = new ArrayList<>();
        posts.forEach(post -> {
            postDtos.add(postDtoConverter.convertToDto(post));
        });

        return new GroupSummaryDto.Builder().withGroupId(group.getGroupId())
                .withGroupName(group.getGroupName())
                .withUsers(userDtos)
                .withPosts(postDtos)
                .build();
    }

    @Override
    public Group convertFromDto(GroupSummaryDto groupSummaryDto) {
        return null;
    }
}
