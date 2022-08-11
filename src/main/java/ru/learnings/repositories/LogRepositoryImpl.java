package ru.learnings.repositories;

import lombok.RequiredArgsConstructor;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.learnings.entities.Log;
import ru.learnings.interfaces.repo.LogRepository;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class LogRepositoryImpl implements LogRepository {

    private final SessionFactory sessionFactory;

    @Override
    public void save(Log newLog){
        sessionFactory.getCurrentSession().saveOrUpdate(newLog);
    }

    @Override
    public List<Log> findAll() {
        TypedQuery<Log> query = sessionFactory.getCurrentSession().createQuery("from Log");
        return query.getResultList();
    }


    @Override
    public Optional<Log> findById(Long id) {
        return Optional.ofNullable(sessionFactory.getCurrentSession().get(Log.class, id));
    }

    @Override
    public void deleteById(Long id) {
        Optional<Log> logToDelete = findById(id);
        logToDelete.ifPresent(log ->
                sessionFactory.getCurrentSession().remove(log));
    }

    @Override
    public void delete(Log log) {
        sessionFactory.getCurrentSession().remove(log);
    }

    public List<Log> findAllByUserId(long userId){
        TypedQuery<Log> query = sessionFactory.getCurrentSession().createQuery("from Log where user.id = " + userId);
        return query.getResultList();
    }
}
