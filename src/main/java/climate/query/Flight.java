package climate.query;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "flights")
//@IdClass(FlightId.class)
public class Flight {

    @EmbeddedId
    private FlightId flightId;

    @Column(nullable = false, name = "DESTINATION_AIRPORT")
    private String destAirport;


    // getters and setters

    public FlightId getFlightId() {
        return flightId;
    }

    public void setFlightId(FlightId flightId) {
        this.flightId = flightId;
    }
    public String getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }

    public Flight(){

    }

    public Flight(FlightId flightId, String destAirport){
        this.flightId = flightId;
        this.destAirport = destAirport;
    }

}
