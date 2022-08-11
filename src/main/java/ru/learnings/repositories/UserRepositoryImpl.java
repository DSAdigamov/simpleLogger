package ru.learnings.repositories;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.learnings.entities.User;
import ru.learnings.interfaces.repo.UserRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SessionFactory sessionFactory;

    @Override
    public void save(User newUser){
        sessionFactory.getCurrentSession().saveOrUpdate(newUser);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }


    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(User.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Optional<User> userToDelete = findById(id);
        userToDelete.ifPresent(user ->
                sessionFactory.getCurrentSession().remove(user));
    }

    @Override
    public void delete(User user) {
        sessionFactory.getCurrentSession().remove(user);
    }


}
