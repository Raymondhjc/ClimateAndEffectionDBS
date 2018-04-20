package climate.query;

import org.springframework.data.jpa.repository.Query;

public interface QueryRepository {

    @Query("select a from Airline a where a.name = ?1")
    String findByName(String name);

    @Query("select a from Airline a where a.id = ?1")
    String findByID(int id);

    @Query("select a from Airline a where a.id = ?1")
    String findByIdandRange(String name, String range);

    @Query("select a.name from Airline a where a.id = ?1")
    String findNameById(int id);

    @Query("select w.weather, a.id from Airline a, Weather w where a.id = ?1")
    String findByIdandWeather(int id, String weather);
}
