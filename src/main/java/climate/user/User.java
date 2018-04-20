package climate.user;


import javax.persistence.*;

@Entity
@Table(name = "users")
@SequenceGenerator(name="userId",sequenceName="id")
public class User {

    @Id
    private String name;
    @Column(nullable = false)
    private String password;

    public User() {

    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
