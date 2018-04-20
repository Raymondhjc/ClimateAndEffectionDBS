package climate.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    @Autowired
    private QueryService queryService;

    @RequestMapping("/listAirline")
    public String listAirline(@RequestParam("code") String code){
        return queryService.listAirline(code);
    }
}
