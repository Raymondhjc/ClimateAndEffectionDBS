package climate.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @Column(name = "airline_iata_code")
    private String code;
    @Column(name = "airline", nullable = false)
    private String airline;

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

}
