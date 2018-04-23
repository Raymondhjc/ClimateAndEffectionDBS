package climate.query;

import oracle.sql.DATE;

import java.io.Serializable;
import java.util.Date;


public class FlightId implements Serializable{
    private Date date;
    private String airline;
    private int flightNum;
    private String originAirport;
}
