package edu.miu.cs.najeeb.spring.examprep.Service;

import edu.miu.cs.najeeb.spring.examprep.Entity.House;
import edu.miu.cs.najeeb.spring.examprep.Repository.HouseRepository;
import edu.miu.cs.najeeb.spring.examprep.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseService {
    @Autowired
    private HouseRepository houseRepository;

    public House getExpensiveHouse() {
        return houseRepository.findTopByOrderByPriceDesc();
    }

    public List<House> getHousesWithYear(int year) {
        return houseRepository.getHousesByYear(year);
    }

    public List<House> getHousesPriceGreaterThan(long price) {
        return houseRepository.getHousesByPriceGreaterThan(price);
    }

    public List<House> filter(Integer price, Integer year) {
        Specification<House> spec = Specification.where((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
        if (price != null) {
           spec.and(HouseSpecification.priceGreaterThan(price));
        }
        if (year != null) {
            spec.and(HouseSpecification.yearEqual(year));
        }
        return houseRepository.findAll(spec);
    }

    public void saveHouse(House house) {
        houseRepository.save(house);
    }

    public House getHouse(Long id) {
        return houseRepository.findById(id).orElseThrow(() -> new NotFoundException("House with id " + id + " not found"));
    }

    public void deleteHouse(Long id) {
        House house = houseRepository.findById(id).orElseThrow(() -> new NotFoundException("House with id " + id + " not found"));
        houseRepository.delete(house);
    }

    public void updateHouse(long id, House house) {
        House h = houseRepository.findById(id).orElseThrow(() -> new NotFoundException("House with id " + id + " not found"));
        h.setYear(house.getYear());
        h.setPrice(house.getPrice());
        houseRepository.save(house);
    }

    public List<House> getAllHouses() {
        return houseRepository.findAll();
    }
}
