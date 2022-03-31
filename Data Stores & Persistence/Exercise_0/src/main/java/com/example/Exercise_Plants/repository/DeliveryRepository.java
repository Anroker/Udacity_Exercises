package com.example.Exercise_Plants.repository;

import com.example.Exercise_Plants.entity.Delivery;
import com.example.Exercise_Plants.entity.Plant;
import com.example.Exercise_Plants.projections.RecipientAndPrice;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class DeliveryRepository {
    @PersistenceContext
    EntityManager entityManager;

    public void persist(Delivery delivery) {
        entityManager.persist(delivery);
    }

    public Delivery find(Long id) {
        return entityManager.find(Delivery.class, id);
    }

    public Delivery merge(Delivery delivery) {
        return entityManager.merge(delivery);
    }

    public void delete(Long id) {
        Delivery delivery = entityManager.find(Delivery.class, id);
        entityManager.remove(delivery);
    }

    public List<Delivery> findDeliveriesByName(String name) {
        TypedQuery<Delivery> query = entityManager.createNamedQuery("Delivery.findByName", Delivery.class);
        query.setParameter("name", name);
        return query.getResultList();
    }

    public RecipientAndPrice getBill(Long deliverId) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<RecipientAndPrice> query = criteriaBuilder.createQuery(RecipientAndPrice.class);
        Root<Plant> plantRoot = query.from(Plant.class);
        query.select(
                        criteriaBuilder.construct(
                                RecipientAndPrice.class,
                                plantRoot.get("delivery").get("name"),
                                criteriaBuilder.sum(plantRoot.get("price"))
                        )
                )
                .where(criteriaBuilder.equal(plantRoot.get("delivery").get("id"), deliverId));
        return entityManager.createQuery(query).getSingleResult();
    }
}
