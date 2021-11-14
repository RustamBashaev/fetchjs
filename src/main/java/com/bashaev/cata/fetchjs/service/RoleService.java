package com.bashaev.cata.fetchjs.service;



import com.bashaev.cata.fetchjs.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> allRoles();

    void addRoles(Role role);

    Role getRoleByName(String name);

    Role getRoleById(Long id);
}
