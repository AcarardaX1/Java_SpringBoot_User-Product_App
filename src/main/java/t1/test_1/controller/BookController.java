package t1.test_1.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import t1.test_1.entity.Book;
import t1.test_1.service.BookService;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService service;



    @PostMapping("/addBook")
    public Object  addBook(@RequestBody Book book) {
        Book returnedBook =  service.saveBook(book);
        if (returnedBook == null){
            return "Duplicate Book";
        }
        return returnedBook;

    }

    @PostMapping("/addBooks")
    public List<Book> addBooks(@RequestBody List<Book> books) {
        return service.saveBookList(books);
    }

    @GetMapping
    public List<Book> findAllBooks(){
        return service.getBookList();
    }

    @GetMapping("/{id}")
    public Book findBookById(@PathVariable int id){
        return service.getBookById(id);
    }

    @PutMapping("/update")
    public Book updateBook(@RequestBody Book book) {
        return service.put(book);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBook(@PathVariable int id){
        return service.deleteBook(id);
    }

    @PostMapping("/filter")
    public List<Book> filterBook(@RequestBody Book book) {
        return service.filter(book);}


    @PostMapping("/filterbyBookName")
    public List<Book> filterbyBookName(@RequestBody Book book) {return service.BookNameFilter(book.getBookName());}

    @PostMapping("/filterByQuantity")
    public ResponseEntity<List<Book>> filterBooksByQuantity(
            @RequestBody Book book,
            @RequestParam(required = false) Integer lowerBound,
            @RequestParam(required = false) Integer upperBound) {
        if (lowerBound == null && upperBound == null){
            if (book.getQuantity() == null) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            List<Book> books = service.getBookByQuantity(book.getQuantity());
            return new ResponseEntity<List<Book>>(books, HttpStatus.ACCEPTED );
        }
        List<Book> books = service.getBookByQuantityBounds(upperBound, lowerBound);
        return new ResponseEntity<>(books, HttpStatus.ACCEPTED);
    }


   @GetMapping("/filterByEndDate")
   public List<Book> filterbyEndDate(@RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date endDate)
   {
       return service.getBooksBeforeDate(endDate) ;}




}
