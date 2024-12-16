package edu.miu.cs.najeeb.spring.examprep.Controller;

import edu.miu.cs.najeeb.spring.examprep.Entity.House;
import edu.miu.cs.najeeb.spring.examprep.Service.HouseService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HouseController implements InitializingBean {
    @Autowired
    private HouseService houseService;

    @Autowired
    private MessageSource messageSource;

    @Value("${spring.application.name}")
    private String appName;

    @GetMapping("/greet")
    public String greet() {
        return messageSource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
    }

    @GetMapping("/houses/{id}")
    public House getHouse(@PathVariable Long id) {
        return houseService.getHouse(id);
    }

    @GetMapping(value = "/houses")
    public List<House> getHouses(@RequestParam(required = false) Integer year, @RequestParam(required = false) Long price) {
        if (year != null) {
            return houseService.getHousesWithYear(year);
        } else if (price != null) {
            return houseService.getHousesPriceGreaterThan(price);
        }
        return houseService.getAllHouses();
    }

    @GetMapping(path = "/houses/expensive")
    public House getMostExpensiveHouse() {
        return houseService.getExpensiveHouse();
    }

    @PostMapping("/houses")
    public House createHouse(@RequestBody House house) {
        houseService.saveHouse(house);
        return house;
    }

    @PutMapping("/houses/{id}")
    public House updateHouse(@RequestBody House house, @PathVariable Long id) {
        houseService.updateHouse(id, house);
        return house;
    }

    @DeleteMapping("/houses/{id}")
    public void deleteHouse(@PathVariable Long id) {
        houseService.deleteHouse(id);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Application Name: " + appName);
    }
}
