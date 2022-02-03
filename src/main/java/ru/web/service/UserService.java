package ru.web.service;


import ru.web.model.User;

import java.util.List;

    public interface UserService {
    List<User> getAll();
    User select(long id);
    void save(User user);
    void delete(long id);
    void update(long id, User user);
}
