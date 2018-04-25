package climate.query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Tweets")
public class Tweet {

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

    public Tweet(){

    }

    public Tweet(int id, String sentiment, String reason, String airline, String text, Date dateCreated) {
        this.id = id;
        this.sentiment = sentiment;
        this.reason = reason;
        this.airline = airline;
        this.text = text;
        this.dateCreated = dateCreated;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }
}
