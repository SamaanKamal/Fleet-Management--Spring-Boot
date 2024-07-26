package com.example.FleetManagementDemo.Repository;

import com.example.FleetManagementDemo.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat,Long> {
    List<Seat> findByBusId(Long busId);

    Optional<Seat> findBySeatNumberAndBusId(String seatNumber, Long busId);


//    @Query("SELECT s FROM Seat s WHERE s.bus.id = :busId AND s.user IS NULL")
//    List<Seat> findAvailableSeatsByBusId(@Param("busId") Long busId);

    @Query("SELECT s FROM Seat s " +
            "WHERE s.bus.id IN (" +
            "  SELECT b.id FROM Bus b " +
            "  JOIN Stop stop ON stop.trip.id = :tripId" +
            ") " +
            "AND s.user IS NULL")
    List<Seat> findAvailableSeatsByTripId(@Param("tripId") Long tripId);
//    @Query("SELECT s FROM Seat s WHERE s.bus.id IN (SELECT t.bus.id FROM Trip t WHERE t.startCity.id = :startCityId AND t.endCity.id = :endCityId) AND s.user IS NULL")
//    List<Seat> findAvailableSeatsBetweenStations(@Param("startCityId") Long startCityId, @Param("endCityId") Long endCityId);

    @Query("SELECT CASE WHEN COUNT(b) > 0 THEN true ELSE false END FROM Booking b " +
            "JOIN Stop s1 ON b.trip.id = s1.trip.id " +
            "JOIN Stop s2 ON b.trip.id = s2.trip.id " +
            "WHERE b.seatNumber = :seatNumber " +
            "AND s1.city.id = :startCityId " +
            "AND s2.city.id = :endCityId " +
            "AND s1.stopOrder < s2.stopOrder")
    boolean isSeatBookedBetweenStops(@Param("seatNumber") String seatNumber,
                                     @Param("startCityId") Long startCityId,
                                     @Param("endCityId") Long endCityId);

}
