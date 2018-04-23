package climate.query;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flights")
//@IdClass(FlightId.class)
public class Flight {

    @Id
    @Column(name = "YEAR_MONTH_DAY")
    private Date date;

    //@Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline")
//    @Column(name = "airline")
    private Airline airline;

    //@Id
    @Column(name = "FLIGHT_NUMBER")
    private int flightNum;

    //@Id
    @Column(name = "ORIGIN_AIRPORT")
    private String originAirport;

    @Column(nullable = false, name = "DESTINATION_AIRPORT")
    private String destAirport;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public void setFlightNum(int flightNum) {
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

    public Flight(){

    }

    public Flight(Date date, Airline airline, int flightNum, String originAirport, String destAirport) {
        this.date = date;
        this.airline = airline;
        this.flightNum = flightNum;
        this.originAirport = originAirport;
        this.destAirport = destAirport;
    }

}
