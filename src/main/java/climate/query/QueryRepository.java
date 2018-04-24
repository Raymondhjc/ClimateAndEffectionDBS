package climate.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

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

    @Query("select t from Tweet t where t.text like %:weather%")
    List<Tweet> findByAirline(@Param("weather") String weather);

    //flight time
    @Query("select f.airline from FlightTime f where f.airline = id")
    List<FlightTime> findByDuration(String id);

    // query for the flight with a duration
//    @Query("select f.airline, f.flightNum, min(f.arrTime - f.depTime) from FlightTime f where f.FlightTimeId = ?1 group by f.airline")
//    Object[] findByDuration(FlightTimeId id);

//    @Query("select t from Tweet t where t.sentiment = ?1 and t.reason = ?2")
//    List<Tweet> findTweetByReason(Date date, String origin, String destination);
}
