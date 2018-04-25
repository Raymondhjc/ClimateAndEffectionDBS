package climate.query;

import javafx.util.Pair;
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

    @Autowired
    private FlightQueryRepository flightQueryRepository;

    public List<String> listAirline(String code) {
        return queryRepository.findAirlineByCode(code);
    }

//    public List<Object[]> findFlight(String destAirport){
//        String destCode = queryRepository.findCodeByAirport(destAirport);
//        return queryRepository.findByDest(destCode);
//    }

    public List<Flight> findFlight(String originAirport, String destAirport) {
        String originCode = queryRepository.findCodeByAirport(originAirport);
        String destCode = queryRepository.findCodeByAirport(destAirport);
        return queryRepository.findByOriginAndDest(originCode, destCode);
    }

    public List<Flight> findFlight(String date) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try {
            d = format1.parse(date);
        } catch (ParseException e) {
            System.out.println(e);
        }
        return queryRepository.findByDate(d);
    }

    public List<Flight> findFlight(String date, String originAirport, String destAirport) {
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date d = new Date();
        try {
            d = format1.parse(date);
        } catch (ParseException e) {
            System.out.println(e);
        }
        String originCode = queryRepository.findCodeByAirport(originAirport);
        String destCode = queryRepository.findCodeByAirport(destAirport);
        return queryRepository.findByDateLoc(d, originCode, destCode);
    }


    // query for the flight with a duration
    public List<Object[]> findFlightByDuration(String origin, String destination) {
        String ori = queryRepository.findCodeByAirport(origin);
        String dest = queryRepository.findCodeByAirport(destination);
        return flightQueryRepository.findByDuration(ori, dest);
    }

    public List<FlightTime> test(String id) {
        return queryRepository.findByDuration(id);
    }


    /**
     * insight about the data
     * Tweet
     */

    public List<Pair<String, Integer>> findTweet(String word) {

        List<Pair<String, Integer>> res = new ArrayList<>();
        List<Object[]> query = queryRepository.findTweetByWord(word);
        for(Object[] o : query){
            Pair<String, Integer> pair = new Pair<>((String)o[0], (Integer)o[1]);
            res.add(pair);
        }
        return res;
    }


}
