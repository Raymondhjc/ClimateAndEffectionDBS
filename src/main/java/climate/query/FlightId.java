package climate.query;

import oracle.sql.DATE;
import oracle.sql.NUMBER;

import java.io.Serializable;


public class FlightId implements Serializable{
    private DATE date;
    private String airline;
    private NUMBER flightNum;
    private String originAirport;
}
