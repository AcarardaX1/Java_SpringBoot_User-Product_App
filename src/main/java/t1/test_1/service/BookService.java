package t1.test_1.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t1.test_1.entity.Book;
import t1.test_1.repository.BookRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;


@Service
public class BookService {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book saveBook(Book book) {
        boolean isBookExist = getBookList().stream().anyMatch(
                bookHold ->
                        bookHold.getBookName() != null
                                && bookHold.getBookName().equalsIgnoreCase(book.getBookName())
        );
        if (isBookExist) {
            return null;
        }
        return repository.save(book);
    }

    public List<Book> saveBookList(List<Book> books) {
        return repository.saveAll(books);
    }

    public List<Book> getBookList() {

        return repository.findAll();
    }

    public Book getBookById(int id) {

        return repository.findById(id).orElse(null);
    }

    public String deleteBook(int id) {
        repository.deleteById(id);
        return "Product Removed !! " + id;
    }


    public List<Book> filter(Book book) {
        if (book.getQuantity() != null) {
            return repository.findAllByQuantity(book.getQuantity());
        }
        return repository.findAllByISBNContaining(book.getISBN()).orElse(null);
    }

    public List<Book> getBookByQuantity(int quantity) {
        return repository.findAllByQuantity(quantity);
    }

    public List<Book> getBookByQuantityBounds(Integer upperBound, Integer lowerBound) {

        return repository.findByQuantityBetween(lowerBound, upperBound);
    }

    public List<Book> BookNameFilter(String bookName) {

        return repository.findAllByBookNameContaining(bookName).orElse(null);
    }

    public Book put(Book book) {

        Book existingBook = repository.findById(book.getId()).orElse(null);
        if (existingBook != null) {
            repository.save(book);
            return book;           //Update
        }
        return null;
    }


//    public long toConvertepoch(Date startDate, Date endDate){
//
//        LocalDate startLocalDate = Instant.ofEpochMilli(startDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
//        LocalDate endLocalDate = Instant.ofEpochMilli(endDate.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
//
//
//        long startEpoch = startLocalDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
//        long endEpoch = endLocalDate.atStartOfDay(ZoneId.systemDefault()).toEpochSecond();
//
//        return  ChronoUnit.DAYS.between(startLocalDate, endLocalDate);
//
//    }

//    public List<Book> getBooksByDateRange(Date startDate, Date endDate) {
//        return repository.findByPublishedDateBetween(startDate, endDate);
//    }

    public List<Book> EndDateFilter(Date endDate) {

        return repository.findAllByEndDate(endDate).orElse(null);
    }


    public List<Book> getBooksBeforeDate(Date endDate) {
        List<Book> allBooks = repository.findAll();

        List<Book> filteredBooks = new ArrayList<>();
        for (Book book : allBooks) {
            if (book.getEndDate().before(endDate)) {
                filteredBooks.add(book);
            }
        }

        return filteredBooks;
    }
}






