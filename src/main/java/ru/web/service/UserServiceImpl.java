package ru.web.service;

import ru.web.model.User;
import ru.web.dao.UserDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    @Override
    public User select(long id) {
        return userDAO.select(id);
    }

    @Override
    public void save(User user) {
        userDAO.save(user);
    }

    @Override
    public void delete(long id) {
        userDAO.delete(id);
    }

    @Override
    public void update(long id, User user) {
        userDAO.update(id, user);
    }

    @Override
    public List<User> getAll() {
        return userDAO.getAll();
    }

}
