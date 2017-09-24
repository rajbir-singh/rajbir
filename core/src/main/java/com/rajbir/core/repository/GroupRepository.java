package com.rajbir.core.repository;

import com.rajbir.core.domain.Group;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sony on 12-09-2017.
 */

public interface GroupRepository extends JpaRepository<Group, Long>, GroupRepositoryCustom {
    public Page<Group> findAll(Pageable page);
    public Group findByGroupId(String groupId);
}
