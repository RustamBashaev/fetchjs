package com.bashaev.cata.fetchjs.service;



import com.bashaev.cata.fetchjs.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> getAll();

    public Optional<User> getOne(Long id);

    public void addNew(User user);

    public void update(User user);

    public void removeUserById(Long id);

    public User getUserById(Long id);


}
