package climate.query;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    @RequestMapping("/query")
    public String queryHandler() {
        return "q1";
    }
}
