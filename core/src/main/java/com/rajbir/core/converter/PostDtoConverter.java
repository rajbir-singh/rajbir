package com.rajbir.core.converter;

import com.rajbir.core.domain.Post;
import com.rajbir.core.dto.PostDto;
import com.rajbir.core.service.Utils;
import org.springframework.stereotype.Component;

/**
 * Created by Sony on 24-09-2017.
 */
@Component
public class PostDtoConverter implements DtoConverter<Post, PostDto> {
    @Override
    public PostDto convertToDto(Post post) {
        if(Utils.isEmptyObject(post)) {
            return null;
        }
        return new PostDto.Builder()
                .withPostId(post.getPostId())
                .withMessage(post.getMessage())
                .withTime(post.getTime())
                .withByUserId(post.getByUserId())
                .withByUserName(post.getByUserName())
                .withGroupId(post.getGroup().getGroupId())
                .build();
    }

    @Override
    public Post convertFromDto(PostDto postDto) {
        return null;
    }
}
