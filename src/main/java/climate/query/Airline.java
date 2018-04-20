package climate.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    private String airline_iata_code;
    @Column(nullable = false)
    private String airline;

    public Airline(String airline_iata_code, String airline) {
        this.airline_iata_code = airline_iata_code;
        this.airline = airline;
    }

    public String getAirline_iata_code() {
        return airline_iata_code;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline_iata_code(String airline_iata_code) {
        this.airline_iata_code = airline_iata_code;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

}
