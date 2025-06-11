package codesquadBoardPratice.Elbin.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
@Entity
@Table(name = "Users")
public class User {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String loginId;

    @Column(nullable = false)
    private String password;

    public User(String loginId, String password) {
        if(loginId == null || loginId.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("loginId and password cannot be empty");
        }
        this.loginId = loginId;
        this.password = password;
    }


}
