package climate.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightQueryRepository extends CrudRepository<FlightTime, FlightTimeId> {

    // query for the flight with a duration
    @Query("select f.flightTimeId.airline, f.flightTimeId.flightNum, min(f.depTime - f.arrTime) from FlightTime f " +
            "where f.flightTimeId.originAirport = ?1 and f.destAirport = ?2 group by f.flightTimeId.airline, f.flightTimeId.flightNum")
    List<Object[]> findByDuration(String origin, String dest);

    /**
     *  query insights
     */
    @Query("select f from FlightTime f where f.depDelay is not null and f.flightTimeId.originAirport = ?1 and ")
    List<FlightTime> findByDuration(String id);

}
