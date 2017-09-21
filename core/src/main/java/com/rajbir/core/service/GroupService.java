package com.rajbir.core.service;

import com.rajbir.core.domain.Group;
import com.rajbir.core.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * Created by Sony on 12-09-2017.
 */
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;

    public Page<Group> findGroupsPageable(PageRequest page) {
        return groupRepository.findAll(page);
    }

}
