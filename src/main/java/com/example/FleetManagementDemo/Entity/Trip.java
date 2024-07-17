package com.example.FleetManagementDemo.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "trips")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "start_city_id", nullable = false)
    private City startCity;

    @ManyToOne
    @JoinColumn(name = "end_city_id", nullable = false)
    private City endCity;
    @Column(name = "departure_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date departureTime;

    public Trip() {
    }

    public Trip(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }
}
