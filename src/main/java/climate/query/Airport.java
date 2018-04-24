package climate.query;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "airports")
public class Airport {

    @Autowired

    @Id
    @Column(name = "airport_iata_code")
    private String code;
    @Column(name = "airport", nullable = false)
    private String airport;
    @Column(name = "state", nullable = false)
    private String state;
    @Column(name = "city", nullable = false)
    private String city;

    public Airport(String code, String airport) {
        this.code = code;
        this.airport = airport;
    }

    public String getCode() {
        return code;
    }

    public String getAirport() {
        return airport;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setAirport(String airport) {
        this.airport = airport;
    }


}
