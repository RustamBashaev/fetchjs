package com.bashaev.cata.fetchjs.service;


import com.bashaev.cata.fetchjs.model.Role;
import com.bashaev.cata.fetchjs.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Рустам
 */

@Service
public class RoleServiceImpl implements RoleService{

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> allRoles() {
        return roleRepository.findAll();
    }

    @Override
    public void addRoles(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String name) {
        return roleRepository.findRoleByName(name);
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findRoleById(id);
    }
}
