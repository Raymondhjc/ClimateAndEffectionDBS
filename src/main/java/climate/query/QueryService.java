package climate.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class QueryService {

    private Airline airline;
    //private Airport airport;

    @Autowired
    private QueryRepository queryRepository;

    public List<String> listAirline(String code){
        return queryRepository.findAirlineByCode(code);
    }

//    public List<Object[]> findFlight(String destAirport){
//        String destCode = queryRepository.findCodeByAirport(destAirport);
//        return queryRepository.findByDest(destCode);
//    }

    public List<Flight> findFlight(String originAirport, String destAirport){
        String originCode = queryRepository.findCodeByAirport(originAirport);
        String destCode = queryRepository.findCodeByAirport(destAirport);
        return queryRepository.findByOriginAndDest(originCode, destCode);
    }

    public List<Flight> findFlight(String date){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try{
            d = format1.parse(date);
        }catch (ParseException e){
            System.out.println(e);
        }
        return queryRepository.findByDate(d);
    }

    public List<Flight> findFlight(String date, String originAirport, String destAirport){
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try{
            d = format1.parse(date);
        }catch (ParseException e){
            System.out.println(e);
        }
        String originCode = queryRepository.findCodeByAirport(originAirport);
        String destCode = queryRepository.findCodeByAirport(destAirport);
        return queryRepository.findByDateLoc(d, originCode, destCode);
    }

    public List<Tweet> findTweet(String weather){
        return queryRepository.findByAirline(weather);
    }

    // query for the flight with a duration
//    public List<Object[]> findFlightByDuration(String origin, String dest){
//        List<Flight> flights = findFlight(origin, dest);
//        List<Object[]> res = new ArrayList<>();
//        for(Flight f : flights){
//            FlightTimeId id = new FlightTimeId(f.getFlightId().getDate(), f.getFlightId().getAirline(),
//                    f.getFlightId().getFlightNum(), f.getFlightId().getOriginAirport());
//            res.add(queryRepository.findByDuration(id));
//        }
//        return res;
//    }

    public List<FlightTime> test(String id){
        return queryRepository.findByDuration(id);
    }
}
