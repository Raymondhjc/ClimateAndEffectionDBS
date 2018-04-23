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

    @Query("select f.airline, f.flightNum from Flight f where f.originAirport = ?1 and f.destAirport = ?2")
    List<Object[]> findByOriginAndDest(String origin, String destination);

    @Query("select f.airline, f.flightNum from Flight f where f.destAirport = ?1")
    List<Object[]> findByDest(String destination);

    @Query("select f.airline, f.flightNum from Flight f where f.date = ?1")
    List<Object[]> findByDate(Date date);

}
