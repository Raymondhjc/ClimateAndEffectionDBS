package climate.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping("/listAirline")
    public List<String> listAirline(@RequestParam("code") String code){
        return queryService.listAirline(code);
    }
//
//    @RequestMapping("/listFlightDest")
//    public List<Object[]> listFlight(@RequestParam("dest") String dest){
//        return queryService.findFlight(dest);
//    }
    @RequestMapping("/listFlightOriDest")
    public List<Flight> listFlight(@RequestParam("ori") String origin, @RequestParam("dest") String dest){
        return queryService.findFlight(origin, dest);
    }

    @RequestMapping("/listFlightDate")
    public List<Flight> listFlight(@RequestParam("date") String date){
        return queryService.findFlight(date);
    }

    @RequestMapping("/listFlightDateLoc")
    public List<Flight> listFlight(@RequestParam("date") String date, @RequestParam("ori") String origin, @RequestParam("dest") String dest){
        return queryService.findFlight(date, origin, dest);
    }

    @RequestMapping("/queryTweetWeather")
    public List<Tweet> listTweet(@RequestParam("weather") String weather){
        return queryService.findTweet(weather);
    }
//    @RequestMapping("/queryAirlineDuration")
//    public List<Object[]> findFastest(@RequestParam("ori") String origin, @RequestParam("dest") String dest){
//        return queryService.findFlightByDuration(origin, dest);
//    }

    @RequestMapping("/test")
    public List<FlightTime> test(@RequestParam("ori") String origin){
        return queryService.test(origin);
    }

}
