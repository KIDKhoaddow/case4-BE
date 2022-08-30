package case4.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    private String avatar;

    private String phoneNumber;

    private String birthDay;

    private String address;
    private String registerDate;


    @OneToOne
    private User user;


    public UserInfo(String firstName, String lastName, String email, String avatar, String phoneNumber, String birthDay, String address, String registerDate, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.avatar = avatar;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
        this.registerDate = registerDate;
        this.user = user;
    }

    public UserInfo(String firstName, String lastName, String email, String phoneNumber, String birthDay, String address, String registerDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
        this.registerDate = registerDate;
    }

    public UserInfo(String firstName, String lastName, String email, String phoneNumber, String birthDay, String address, String registerDate, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthDay = birthDay;
        this.address = address;
        this.registerDate = registerDate;
        this.user = user;
    }
}
