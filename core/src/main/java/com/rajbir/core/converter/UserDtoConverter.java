package com.rajbir.core.converter;

import com.rajbir.core.domain.Group;
import com.rajbir.core.domain.User;
import com.rajbir.core.dto.GroupDto;
import com.rajbir.core.dto.UserDto;
import com.rajbir.core.service.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 08-09-2017.
 */
@Service
public class UserDtoConverter implements DtoConverter<User, UserDto> {

    @Autowired
    private GroupDtoConverter groupDtoConverter;

    @Override
    public UserDto convertToDto(User user) {
        if (Utils.isEmptyObject(user)) {
            return null;
        }

        List<Group> groups = user.getGroups();
        List<GroupDto> groupDtos = new ArrayList<>();
        if(groups != null && !groups.isEmpty()) {
            for (Group group : groups) {
                groupDtos.add(groupDtoConverter.convertToDto(group));
            }
        }

        return UserDto.Builder.userDto()
                .withUserId(user.getUserId())
                .withName(user.getName())
                .withEmail(user.getEmail())
                .withMobile(user.getMobile())
                .withPassword(user.getPassword())
                .withGroups(groupDtos)
                .withAboutMe(user.getAboutMe())
                .build();
    }

    //TODO: user groupConverter
    @Override
    public User convertFromDto(UserDto userDto) {

        List<Group> groups = new ArrayList<>();
        List<GroupDto> groupDtos = userDto.getGroups();
        if(groupDtos != null && !groupDtos.isEmpty()) {
            for (GroupDto groupDto : groupDtos) {
                groups.add(groupDtoConverter.convertFromDto(groupDto));
            }
        }
        return new User.Builder()
                .withUserId(userDto.getUserId())
                .withName(userDto.getName())
                .withEmail(userDto.getEmail())
                .withMobile(userDto.getMobile())
                .withPassword(userDto.getPassword())
                .withGroups(groups)
                .withAboutMe(userDto.getAboutMe())
                .build();
    }
}
