package edu.miu.cs.najeeb.spring.examprep.Service;

import edu.miu.cs.najeeb.spring.examprep.Entity.House;
import org.springframework.data.jpa.domain.Specification;

public class HouseSpecification {
    public static Specification<House> priceGreaterThan(long price) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("price"), price);
    }

    public static Specification<House> yearEqual(int year) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("year"), year);
    }
}
