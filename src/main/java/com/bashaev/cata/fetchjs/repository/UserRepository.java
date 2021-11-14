package com.bashaev.cata.fetchjs.repository;


import com.bashaev.cata.fetchjs.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public void removeUserById(Long id);

    public User findUserByName(String name);

    public User findUserByEmail(String email);

    public User findUserById(Long id);
}
