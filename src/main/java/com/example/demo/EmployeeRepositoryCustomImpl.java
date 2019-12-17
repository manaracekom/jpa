package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @Autowired
    private EntityManager em;

    @Override
    public Employee findByFirstNameCustom(String firstName) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> root = cq.from(Employee.class);

        List<Predicate> listWhere = new ArrayList<>();
        listWhere.add(cb.equal(root.get("firstName"), firstName));

        TypedQuery<Employee> tq = em.createQuery(cq
            .select(root)
            .where(listWhere.toArray(new Predicate[]{})));

        return tq.getSingleResult();
    }
}
