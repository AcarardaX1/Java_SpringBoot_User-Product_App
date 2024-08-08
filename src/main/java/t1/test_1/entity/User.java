package t1.test_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_TBL")
public class User  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String first_name;
    private String last_name;
    private String email;
    private String phoneNumber;



    public void setName(String firstName) {
    }
}
