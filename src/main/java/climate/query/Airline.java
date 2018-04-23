package climate.query;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @Column(name = "airline_iata_code")
    private String code;
    @Column(name = "airline", nullable = false)
    private String airline;

    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
    private List<Flight> flights = new ArrayList<>();

    public Airline(String code, String airline) {
        this.code = code;
        this.airline = airline;
    }

    public String getCode() {
        return code;
    }

    public String getAirline() {
        return airline;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }


//    public List<Flight> getFlights() {
//        return flights;
//    }
//
//    public void setFlights(List<Flight> flights) {
//        this.flights = flights;
//    }

}
