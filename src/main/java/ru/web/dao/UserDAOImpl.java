package ru.web.dao;

import ru.web.model.User;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Transactional
@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> getAll(){
        return em.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public User select(long id){
        return em.find(User.class, id);
    }

    @Override
    public void save(User user){
        em.persist(user);
    }

    @Override
    public void delete(long id){
        em.remove(select(id));
    }

    @Override
    public void update(long id, User userVariable){
        User user = select(id);
        user.setName(userVariable.getName());
        user.setSurname(userVariable.getSurname());
        user.setAge(userVariable.getAge());
    }

}
