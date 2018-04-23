package climate.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QueryRepository extends CrudRepository<Airline, Integer> {

    @Query("select a.airline from Airline a where a.code = ?1")
    String findAirlineByCode(String code);

    @Query("select a.flights from Airline a where a.code = ?1")
    List<Flight> findFlightByAirline(String code);

//    @Query("select a from Airline a where a.id = ?1")
//    String findByID(int id);
//
//    @Query("select a from Airline a where a.id = ?1")
//    String findByIdandRange(String name, String range);
//
//    @Query("select a.name from Airline a where a.id = ?1")
//    String findNameById(int id);
//
//    @Query("select w.weather, a.id from Airline a, Weather w where a.id = ?1")
//    String findByIdandWeather(int id, String weather);
}
