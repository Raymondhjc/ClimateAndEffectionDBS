package climate.query;

import javax.persistence.*;

@Entity
@Table(name = "Flights_Time")
public class FlightTime {
    @EmbeddedId
    private FlightTimeId flightTimeId;

    @Column(name = "DESTINATION_AIRPORT")
    private String destAirport;

    @Column(name = "DAY_OF_WEEK", nullable = false)
    private Integer day;

    @Column(name = "SCHEDULED_DEPARTURE_TIME", nullable = false)
    private Integer schDepTime;

    @Column(name = "DEPARTURE_TIME")
    private Integer depTime;

    @Column(name = "DEPARTURE_DELAY")
    private Integer depDelay;

    @Column(name = "SCHEDULED_ARRIVE_TIME", nullable = false)
    private Integer schArrTime;

    @Column(name = "ARRIVE_TIME")
    private Integer arrTime;

    @Column(name = "ARRIVE_DELAY")
    private Integer arrDelay;

    @Column(name = "CANCELLED")
    private Integer cancelled;

    public FlightTimeId getFlightTimeId() {
        return flightTimeId;
    }

    public void setFlightTimeId(FlightTimeId flightTimeId) {
        this.flightTimeId = flightTimeId;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getSchDepTime() {
        return schDepTime;
    }

    public void setSchDepTime(Integer schDepTime) {
        this.schDepTime = schDepTime;
    }

    public Integer getDepTime() {
        return depTime;
    }

    public void setDepTime(Integer depTime) {
        this.depTime = depTime;
    }

    public Integer getDepDelay() {
        return depDelay;
    }

    public void setDepDelay(Integer depDelay) {
        this.depDelay = depDelay;
    }

    public Integer getSchArrTime() {
        return schArrTime;
    }

    public void setSchArrTime(Integer schArrTime) {
        this.schArrTime = schArrTime;
    }

    public Integer getArrTime() {
        return arrTime;
    }

    public void setArrTime(Integer arrTime) {
        this.arrTime = arrTime;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }

    public String getDestAirport() {
        return destAirport;
    }

    public void setDestAirport(String destAirport) {
        this.destAirport = destAirport;
    }

    public Integer getArrDelay() {
        return arrDelay;
    }

    public void setArrDelay(Integer arrDelay) {
        this.arrDelay = arrDelay;
    }

    public FlightTime() {
    }

    public FlightTime(FlightTimeId flightTimeId, String destAirport, Integer day, Integer schDepTime, Integer depTime, Integer depDelay, Integer schArrTime, Integer arrTime, Integer arrDelay, Integer cancelled) {
        this.flightTimeId = flightTimeId;
        this.destAirport = destAirport;
        this.day = day;
        this.schDepTime = schDepTime;
        this.depTime = depTime;
        this.depDelay = depDelay;
        this.schArrTime = schArrTime;
        this.arrTime = arrTime;
        this.arrDelay = arrDelay;
        this.cancelled = cancelled;
    }
}
