package t1.test_1.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.time.OffsetDateTime;
import java.time.ZonedDateTime;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK_TBL")
@JsonIgnoreProperties({"userList"})
public class Book {


    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "bookList",cascade = {
            CascadeType.ALL
    })


    private List<User> userList;

    private String bookName;
    private Integer quantity;
    private String ISBN;
    private Date endDate;
    private String startDate;


//    @CreationTimestamp
//    private LocalDateTime dateCreated;
//
//    @UpdateTimestamp
//    private LocalDateTime lastUpdated;

//    public Book getStartDate(Book book) {
//        return book;
//    }
//
//    public Book getEndDate(Book book) {
//        return book;
//    }

    //private int IntervalTime = count(Integer(EndDate-StartDate));
}
