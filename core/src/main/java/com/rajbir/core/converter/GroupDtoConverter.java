package com.rajbir.core.converter;

import com.rajbir.core.domain.Group;
import com.rajbir.core.domain.Post;
import com.rajbir.core.domain.User;
import com.rajbir.core.dto.GroupDto;
import com.rajbir.core.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 24-09-2017.
 */
@Component
public class GroupDtoConverter implements DtoConverter<Group, GroupDto>{

    @Autowired
    private UserDtoConverter userDtoConverter;

    @Autowired
    private PostDtoConverter postDtoConverter;

    @Override
    public GroupDto convertToDto(Group group) {
        if(Utils.isEmptyObject(group)) {
            return null;
        }

        List<User> userList = group.getUsers();
        List<String> userIds = new ArrayList<>();
        userList.forEach(user -> {
            userIds.add(user.getUserId());
        });


        List<Post> posts = group.getPosts();
        List<Long> postIds = new ArrayList<>();
        if(posts != null && !posts.isEmpty()){
            posts.forEach(post -> {
                postIds.add(post.getPostId());
            });
        }

        return new GroupDto.Builder().withGroupId(group.getGroupId())
                .withGroupName(group.getGroupName())
                .withUserIds(userIds)
                .withPostIds(postIds)
                .build();
    }

    @Override
    public Group convertFromDto(GroupDto groupDto) {
        return null;
    }
}
