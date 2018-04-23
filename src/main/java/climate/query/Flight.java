package climate.query;

import oracle.sql.DATE;
import oracle.sql.NUMBER;

import javax.persistence.*;

@Entity
@Table(name = "flights")
@IdClass(FlightId.class)
public class Flight {

    @Id
    @Column(name = "YEAR_MONTH_DAY")
    private DATE date;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline")
//    @Column(name = "airline")
    private Airline airline;

    @Id
    @Column(name = "FLIGHT_NUMBER")
    private NUMBER flightNum;

    @Id
    @Column(name = "ORIGIN_AIRPORT")
    private String originAirport;

    @Column(nullable = false, name = "DESTINATION_AIRPORT")
    private String destAirport;

    public DATE getDate() {
        return date;
    }

    public void setDate(DATE date) {
        this.date = date;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public NUMBER getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(NUMBER flightNum) {
        this.flightNum = flightNum;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }


    public Flight(DATE date, Airline airline, NUMBER flightNum, String originAirport, String destAirport) {
        this.date = date;
        this.airline = airline;
        this.flightNum = flightNum;
        this.originAirport = originAirport;
        this.destAirport = destAirport;
    }

}
