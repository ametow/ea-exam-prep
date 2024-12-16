package edu.miu.cs.najeeb.spring.examprep.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PreRemove;

@Entity
public class House {
    @Id@GeneratedValue
    private Long id;
    private int year;
    private long price;

    @PreRemove
    public void preRemove() {
        System.out.println("House with id " + id + " is about to be removed");
    }

    public House() {
    }

    public House(int year, long price) {
        this.year = year;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}
