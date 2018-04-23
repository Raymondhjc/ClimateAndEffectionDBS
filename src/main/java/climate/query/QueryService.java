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

    public List<String> listAirline(String code){
        return queryRepository.findAirlineByCode(code);
    }

    public List<Object[]> findFlight(String destAirport){
        String destCode = queryRepository.findCodeByAirport(destAirport);
        return queryRepository.findByDest(destCode);
    }

    public List<Object[]> findFlight(String originAirport, String destAirport){
        String originCode = queryRepository.findCodeByAirport(originAirport);
        String destCode = queryRepository.findCodeByAirport(destAirport);
        return queryRepository.findByOriginAndDest(originCode, destCode);
    }

//    public List<Airline> findAirline(String code){
//        return queryRepository.findByAirline(code);
//    }
}
