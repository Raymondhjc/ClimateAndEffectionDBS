package climate.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface QueryRepository extends CrudRepository<Flight, String> {

    @Query("select a from Airline a")
    List<Airline> findAirline();

    @Query("select p.code from Airport p where p.airport = ?1")
    String findCodeByAirport(String destination);

    @Query("select f from Flight f where f.flightId.originAirport = ?1 and f.destAirport = ?2")
    List<Flight> findByOriginAndDest(String origin, String destination);

    @Query("select f from Flight f where f.flightId.date = ?1")
    List<Flight> findByDate(Date date);

    @Query("select f from Flight f where f.flightId.date = ?1 and f.flightId.originAirport = ?2 and f.destAirport = ?3")
    List<Flight> findByDateLoc(Date date, String origin, String destination);


    /**
     * some tweet insight
      */
    @Query("select t.sentiment, count(t) from Tweet t where t.text like %:word% group by t.sentiment")
    List<Object[]> findTweetByWord(@Param("word") String word);

    @Query("select t.sentiment, count(t) from Tweet t where t.dateCreated between ?1 and ?2 and t.airline = ?3 group by t.sentiment")
    List<Object[]> findSentimentByAirline(Date date1, Date date2, String airline);

    @Query("select t.reason, count(t) from Tweet t where t.dateCreated between ?1 and ?2 and t.airline = ?3 group by t.reason")
    List<Object[]> findReasonByAirline(Date date1, Date date2, String airline);

    //flight time
    @Query("select f from FlightTime f where f.flightTimeId.airline = ?1")
    List<FlightTime> findByDuration(String id);

//    @Query("select t from Tweet t where t.sentiment = ?1 and t.reason = ?2")
//    List<Tweet> findTweetByReason(Date date, String origin, String destination);

    // query about airports
//    @Query("select a from Airport a where a.airline = ?1")
//    List<Airport> findByAirport(String id);
}
