package climate.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightQueryRepository extends CrudRepository<FlightTime, FlightTimeId> {

    // query for the flight with a duration
    @Query("select f.flightTimeId.airline, f.flightTimeId.flightNum, min(f.arrTime - f.depTime) from FlightTime f where f.flightTimeId.originAirport = ?1 and f.destAirport = ?2 group by f.flightTimeId.airline")
    List<Object[]> findByDuration(String origin, String dest);

}
