package dev.academy.academyFarms.repository;

import dev.academy.academyFarms.model.Farm;
import org.jetbrains.annotations.NotNull;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.*;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FarmRepositoryCustomImpl implements FarmRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Farm> findAllByParams(@NotNull Map<String,String> params) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Farm> query = cb.createQuery(Farm.class);
        Root<Farm> farmRoot = query.from(Farm.class);

        List<Predicate> predicates = new ArrayList<>();

        for (Map.Entry<String, String> entry: params.entrySet()) {
            if (entry.getKey().toLowerCase().equals("datemin")) {
                predicates.add(cb.greaterThanOrEqualTo(farmRoot.get("dateTime"), Instant.parse(entry.getValue())));
            }
            else if (entry.getKey().toLowerCase().equals("datemax")) {
                predicates.add(cb.lessThanOrEqualTo(farmRoot.get("dateTime"), Instant.parse(entry.getValue())));
            }
            else {
                predicates.add(cb.equal(farmRoot.get(entry.getKey()), entry.getValue()));
            }
        }
        query.select(farmRoot)
                .where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query)
                .getResultList();
    }
}
