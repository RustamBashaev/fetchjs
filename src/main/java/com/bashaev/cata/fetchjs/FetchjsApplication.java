package com.bashaev.cata.fetchjs;

import com.bashaev.cata.fetchjs.model.Role;
import com.bashaev.cata.fetchjs.model.User;
import com.bashaev.cata.fetchjs.service.RoleService;
import com.bashaev.cata.fetchjs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class FetchjsApplication implements CommandLineRunner {

    private UserService userService;
    private RoleService roleService;

    @Autowired
    FetchjsApplication(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    public static void main(String[] args) {
        SpringApplication.run(FetchjsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Role role1 = new Role("ROLE_USER");
        Role role2 = new Role("ROLE_ADMIN");

        roleService.addRoles(role1);
        roleService.addRoles(role2);

        Set<Role> roles1 = Set.of(roleService.getRoleByName("ROLE_USER"));
        Set<Role> roles2 = Set.of(roleService.getRoleByName("ROLE_ADMIN"));

        User user1 = new User("user", "userov", "userov@gmail.com", "100", roles1);
        User user2 = new User("admin", "adminov", "adminov@gmail.com", "500", roles2);

        userService.addNew(user1);
        userService.addNew(user2);


    }

}
