package com.rajbir.core.service;

import com.rajbir.core.converter.GroupSummaryDtoConverter;
import com.rajbir.core.domain.Group;
import com.rajbir.core.domain.User;
import com.rajbir.core.dto.CreateGroupDto;
import com.rajbir.core.dto.GroupSummaryDto;
import com.rajbir.core.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sony on 12-09-2017.
 */
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private GroupSummaryDtoConverter groupSummaryDtoConverter;

    public Page<Group> findGroupsPageable(PageRequest page) {
        return groupRepository.findAll(page);
    }

    public GroupSummaryDto createGroup(CreateGroupDto createGroupDto) {
        List<String> userIds = createGroupDto.getUserIds();
        List<User> groupUsers = new ArrayList<>();
        userIds.forEach(userId -> {
            User user = userService.findByUserId(userId);
            groupUsers.add(user);
        });

        Group group = new Group.Builder()
                .withGroupName(createGroupDto.getGroupName())
                .withUsers(groupUsers)
                .withPosts(null)
                .build();
        group = groupRepository.save(group);
        return groupSummaryDtoConverter.convertToDto(group);
    }

    public GroupSummaryDto findByUserId(String groupId) {
        Group group = groupRepository.findByGroupId(groupId);
        return groupSummaryDtoConverter.convertToDto(group);
    }

}
