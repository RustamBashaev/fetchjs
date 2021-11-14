package com.bashaev.cata.fetchjs.repository;


import com.bashaev.cata.fetchjs.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Рустам
 */

public interface RoleRepository extends JpaRepository<Role, Long> {

    public Role findRoleById(Long id);

    public Role findRoleByName(String name);
}
