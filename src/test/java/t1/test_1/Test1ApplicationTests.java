package t1.test_1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import t1.test_1.entity.Book;
import t1.test_1.repository.BookRepository;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootTest
class Test1ApplicationTests {

	@Test
	void contextLoads() {
	}


//	@Test
//	void findByDateCreatedBetweenMethod(){
//
//		LocalDateTime startDate = LocalDateTime.ofEpochSecond(1, 1, ZoneOffset.UTC);
//		LocalDateTime endDate = LocalDateTime.ofEpochSecond(999999999, 999999999, ZoneOffset.UTC);
//
//		List<Book> books = BookRepository.findByDateCreatedBetween(startDate, endDate);
//
//		books.forEach((book -> {
//			System.out.println(book.getId());
//		}));
//	}

}
