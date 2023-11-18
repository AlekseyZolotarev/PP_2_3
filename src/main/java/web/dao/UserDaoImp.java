package web.dao;

import org.springframework.stereotype.Repository;
import web.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers(String sql) {
        return entityManager.createQuery(sql, User.class).getResultList();
    }

    @Override
    public User getUser(int id) {
        if (entityManager.find(User.class, id) != null) {
            return entityManager.find(User.class, id);
        } else {
            System.out.println("getUser no User");
            return null;
        }
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void editUser(int id, User user) {
        if (entityManager.find(User.class, id) != null) {
            User user1 = getUser(id);
            user1.setName(user.getName());
        } else {
            System.out.println("editUser no User");
        }
    }

    @Override
    public void deleteUser(int id) {
        if (entityManager.find(User.class, id) != null) {
            entityManager.remove(entityManager.find(User.class, id));
        } else {
            System.out.println("deleteUser no User");
        }
    }
}
