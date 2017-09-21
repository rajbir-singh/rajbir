package com.rajbir.core.converter;

import com.rajbir.core.domain.User;
import com.rajbir.core.dto.UserDto;
import com.rajbir.core.service.Utils;
import org.springframework.stereotype.Service;

/**
 * Created by Sony on 08-09-2017.
 */
@Service
public class UserDtoConverter implements DtoConverter<User, UserDto> {

    @Override
    public UserDto convertToDto(User user) {
        if (Utils.isEmptyObject(user)) {
            return null;
        }
        return UserDto.Builder.userDto()
                .withUserId(user.getUserId())
                .withName(user.getName())
                .withEmail(user.getEmail())
                .withMobile(user.getMobile())
                .withPassword(user.getPassword())
                .withGroups(user.getGroups())
                .withAboutMe(user.getAboutMe())
                .build();
    }

    //TODO: user groupConverter
    @Override
    public User convertFromDto(UserDto userDto) {
        return new User.Builder()
                .withUserId(userDto.getUserId())
                .withName(userDto.getName())
                .withEmail(userDto.getEmail())
                .withMobile(userDto.getMobile())
                .withPassword(userDto.getPassword())
                .withGroups(userDto.getGroups())
                .withAboutMe(userDto.getAboutMe())
                .build();
    }
}
