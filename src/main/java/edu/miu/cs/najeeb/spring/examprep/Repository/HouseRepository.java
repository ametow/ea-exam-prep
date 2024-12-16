package edu.miu.cs.najeeb.spring.examprep.Repository;

import edu.miu.cs.najeeb.spring.examprep.Entity.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long>, JpaSpecificationExecutor<House> {
    List<House> getHousesByPriceGreaterThan(long price);
    List<House> getHousesByYear(int year);

    House findTopByOrderByPriceDesc();

    @Query(value="select h from House h where h.price = (select max(h1.price) from House h1)", name = "getHouseWithHighestPrice")
    House getHouseWithHighestPrice();
}
