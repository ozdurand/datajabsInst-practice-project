package com.datajabs.datajabsinstitute.repository;

import com.datajabs.datajabsinstitute.model.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Integer> {

    Roles getByRoleName(String roleName);
}
