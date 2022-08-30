package case4.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private  String lastLogin;
    @Enumerated(EnumType.ORDINAL)
    private  Status status;
    private boolean verify;
    @OneToOne
    User user;
}
