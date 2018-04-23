package climate.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QueryService {

    private Airline airline;
    //private Airport airport;

    @Autowired
    private QueryRepository queryRepository;

    public String listAirline(String code){
        return queryRepository.findAirlineByCode(code);
    }

    public List<Flight> listAirlineFlight(String airlineCode){
        return queryRepository.findFlightByAirline(airlineCode);
    }
}
