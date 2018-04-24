package climate.query;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Flights_Time")
public class FlightTime {
    @EmbeddedId
    private FlightTimeId flightTimeId;

    @Column(name = "DAY_OF_WEEK", nullable = false)
    private Date day;

    @Column(name = "SCHEDULED_DEPARTURE_TIME", nullable = false)
    private Airline schDepTime;

    @Column(name = "DEPARTURE_TIME")
    private int depTime;

    @Column(name = "DEPARTURE_DELAY")
    private String depDelay;

    @Column(name = "SCHEDULED_ARRIVE_TIME", nullable = false)
    private int schArrTime;

    @Column(name = "ARRIVE_TIME")
    private String arrTime;

    @Column(name = "CANCELLED")
    private Airline cancelled;

    public FlightTimeId getFlightTimeId() {
        return flightTimeId;
    }

    public void setFlightTimeId(FlightTimeId flightTimeId) {
        this.flightTimeId = flightTimeId;
    }

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Airline getSchDepTime() {
        return schDepTime;
    }

    public void setSchDepTime(Airline schDepTime) {
        this.schDepTime = schDepTime;
    }

    public int getDepTime() {
        return depTime;
    }

    public void setDepTime(int depTime) {
        this.depTime = depTime;
    }

    public String getDepDelay() {
        return depDelay;
    }

    public void setDepDelay(String depDelay) {
        this.depDelay = depDelay;
    }

    public int getSchArrTime() {
        return schArrTime;
    }

    public void setSchArrTime(int schArrTime) {
        this.schArrTime = schArrTime;
    }

    public String getArrTime() {
        return arrTime;
    }

    public void setArrTime(String arrTime) {
        this.arrTime = arrTime;
    }

    public Airline getCancelled() {
        return cancelled;
    }

    public void setCancelled(Airline cancelled) {
        this.cancelled = cancelled;
    }

    public FlightTime() {
    }

    public FlightTime(FlightTimeId flightTimeId, Date day, Airline schDepTime, int depTime, String depDelay, int schArrTime, String arrTime, Airline cancelled) {
        this.flightTimeId = flightTimeId;
        this.day = day;
        this.schDepTime = schDepTime;
        this.depTime = depTime;
        this.depDelay = depDelay;
        this.schArrTime = schArrTime;
        this.arrTime = arrTime;
        this.cancelled = cancelled;
    }
}
