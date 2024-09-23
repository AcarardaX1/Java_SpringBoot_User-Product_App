
package t1.test_1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import t1.test_1.entity.Book;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer>  {

    Optional<List<Book>> findAllByISBN(String ISBN);
    Optional<List<Book>> findAllByISBNContaining(String ISBN);

    Optional<List<Book>> findAllByBookNameContaining(String bookName);

    List<Book> findAllByQuantity(Integer quantity);
    @Query("SELECT e FROM Book e WHERE " +
            "(:lowerBound IS NULL OR e.quantity >= :lowerBound) AND " +
            "(:upperBound IS NULL OR e.quantity <= :upperBound)")
    List<Book> findByQuantityBetween(
            @Param("lowerBound") Integer lowerBound,
            @Param("upperBound") Integer upperBound
    );

    @Query("SELECT b FROM Book b WHERE b.endDate <= :endDate")
    Optional<List<Book>>  findAllByEndDate(@Param("endDate") Date endDate);


//    List<Book> findByPublishedDateBetween(Date startDate, Date endDate);



    //List<Book> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

}




