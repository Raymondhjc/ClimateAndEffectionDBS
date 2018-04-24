package climate.query;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Embeddable
public class FlightTimeId implements Serializable{

    @Column(name = "YEAR_MONTH_DAY")
    private Date date;

    @Column(name = "airline")
    private String airline;

    @Column(name = "FLIGHT_NUMBER")
    private int flightNum;

    @Column(name = "ORIGIN_AIRPORT")
    private String originAirport;

    public Date getDate() {
        return date;
    }

    public String getAirline() {
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

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public void setFlightNum(int flightNum) {
        this.flightNum = flightNum;
    }

    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }

    public FlightTimeId() {
    }

    public FlightTimeId(Date date, String airline, int flightNum, String originAirport) {
        this.date = date;
        this.airline = airline;
        this.flightNum = flightNum;
        this.originAirport = originAirport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlightTimeId)) return false;
        FlightTimeId that = (FlightTimeId) o;
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
