package t1.test_1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor

@Entity
@Table(name = "USER")
public class User  {


    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "user_books",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")

    )



    private List<Book> bookList;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer bookId;
    private Date endDate;
    private String startDate;



    public User() {

    }
}
