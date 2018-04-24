package climate.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface QueryRepository extends CrudRepository<Flight, String> {

    @Query("select a.airline from Airline a where a.code = ?1")
    List<String> findAirlineByCode(String code);

    @Query("select p.code from Airport p where p.airport = ?1")
    String findCodeByAirport(String destination);

    @Query("select f from Flight f where f.flightId.originAirport = ?1 and f.destAirport = ?2")
    List<Flight> findByOriginAndDest(String origin, String destination);

    @Query("select f from Flight f where f.flightId.date = ?1")
    List<Flight> findByDate(Date date);

    @Query("select f from Flight f where f.flightId.date = ?1 and f.flightId.originAirport = ?2 and f.destAirport = ?3")
    List<Flight> findByDateLoc(Date date, String origin, String destination);
}
