package com.app.user_service.repo;

import com.app.user_service.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findActiveUsersWithRoleUser() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = cb.createQuery(User.class);

        Root<User> userRoot = query.from(User.class);

        // WHERE status = "ACTIVE" AND role = "USER"
        Predicate statusPredicate = cb.equal(userRoot.get("status"), "ACTIVE");
        Predicate rolePredicate = cb.equal(userRoot.get("role"), "USER");

        query.select(userRoot)
                .where(cb.and(statusPredicate, rolePredicate));

        return entityManager.createQuery(query).getResultList();
    }
}
