package com.bjit.OnlineBookStoreSpringBoot.service;

import com.bjit.OnlineBookStoreSpringBoot.model.BookRequestModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

public interface BookService {
    ResponseEntity<Object> createBook(BookRequestModel bookRequestModel);
    ResponseEntity<Object> getAllBooks();
    void deleteBooks(Integer bookId);
     ResponseEntity<Object> bookDetails( Integer bookId) ;
    ResponseEntity<Object> getAuthorName(String authorName);
    ResponseEntity<Object> getBookByAuthorName(String authorName, String bookName);
    ResponseEntity<Object> updateBookInfo( Integer id,BookRequestModel updateBookModel) ;

}
