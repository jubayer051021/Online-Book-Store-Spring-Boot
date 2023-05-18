package com.bjit.OnlineBookStoreSpringBoot.controller;

import com.bjit.OnlineBookStoreSpringBoot.model.BookRequestModel;
import com.bjit.OnlineBookStoreSpringBoot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
    private final BookService bookService;

//    1.Create books By Admin
    @PostMapping("/create")
    public ResponseEntity<Object> booksCreate(@RequestBody BookRequestModel bookRequestModel){
        return bookService.createBook(bookRequestModel);
    }

//    2.see all the books from database
    @GetMapping ("/all")
    public ResponseEntity<Object> getAllBooks(){
        return bookService.getAllBooks();
    }

//    3. delete the specific book using bookId
    @DeleteMapping ("/delete/{id}")
    public void deleteBooks(@PathVariable Integer id){
         bookService.deleteBooks(id);
    }

//    4. see book information using bookId
    @GetMapping("/id/{bookId}")
    public ResponseEntity<Object> bookDetails(@PathVariable Integer bookId) {
        return bookService.bookDetails(bookId);
    }

//    5. see Specific authorName BookList
    @GetMapping("/author/{authorName}")
    public ResponseEntity<Object> bookDetails(@PathVariable String authorName) {
        return bookService.getAuthorName(authorName);
    }

    @GetMapping("/author/{authorName}/{bookName}")
    public ResponseEntity<Object> bookDetails(@PathVariable String authorName,@PathVariable String bookName) {
        return bookService.getBookByAuthorName(authorName,bookName);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<Object> updateBookInfo(@PathVariable Integer id,@RequestBody BookRequestModel updateBookModel,ModelAndView model) {
        return bookService.updateBookInfo(id,updateBookModel);
    }
}
