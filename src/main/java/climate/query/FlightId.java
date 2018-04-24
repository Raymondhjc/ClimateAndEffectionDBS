package climate.query;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class FlightId implements Serializable{

    @Column(name = "YEAR_MONTH_DAY")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "airline")
    private Airline airline;

    @Column(name = "FLIGHT_NUMBER")
    private int flightNum;

    @Column(name = "ORIGIN_AIRPORT")
    private String originAirport;

    public Date getDate() {
        return date;
    }

    public Airline getAirline() {
        return airline;
    }

    public int getFlightNum() {
        return flightNum;
    }

    public String getOriginAirport() {
        return originAirport;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightId)) return false;
        FlightId that = (FlightId) o;
        return Objects.equals(getDate(), that.getDate()) &&
                Objects.equals(getAirline(), that.getAirline()) &&
                        getFlightNum() == that.getFlightNum() &&
                                Objects.equals(getOriginAirport(), that.getOriginAirport());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDate(), getAirline(), getFlightNum(), getOriginAirport());
    }

}
