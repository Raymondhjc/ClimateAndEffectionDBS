package climate.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Flights_Time")
public class FlightTime {
    @Id
    @Column(nullable = false, name = "TWEET_ID")
    private long id;

    @Column(name = "AIRLINE_SENTIMENT")
    private String sentiment;

    @Column(name = "NEGETIVE_REASON")
    private String reason;

    @Column(nullable = false, name = "AIRLINE")
    private String airline;

    @Column(nullable = false, name = "TEXT")
    private String text;

    @Column(nullable = false, name = "CREATED_TIME")
    private Date dateCreated;

}
