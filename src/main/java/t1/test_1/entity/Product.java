package t1.test_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PRODUCT_TBL")
public class Product  {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int PID;

    private String p_name;
    private int quantity;


    public void setName(String firstName) {
    }
}
