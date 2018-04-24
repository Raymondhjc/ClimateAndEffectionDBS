package climate.query;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "airlines")
public class Airline {

    @Id
    @Column(name = "airline_iata_code")
    private String code;
    @Column(name = "airline", nullable = false)
    private String airline;

//    @OneToMany(mappedBy = "airline", cascade = CascadeType.ALL)
//    private List<Flight> flights = new ArrayList<>();

    public Airline(){

    }
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;
        Airline that = (Airline) o;
        return Objects.equals(getCode(), that.getCode()) &&
                Objects.equals(getAirline(), that.getAirline());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getAirline());
    }

}
