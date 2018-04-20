package climate.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QueryService {

    private Airline airline;
    //private Airport airport;

    @Autowired
    private QueryRepository queryRepository;

    public String listAirline(String code){
        return queryRepository.findAirlineByCode(code);
    }
}
