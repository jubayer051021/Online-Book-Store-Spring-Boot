package com.bjit.OnlineBookStoreSpringBoot.service.Imp;

import com.bjit.OnlineBookStoreSpringBoot.entity.Book;
import com.bjit.OnlineBookStoreSpringBoot.model.BookRequestModel;
import com.bjit.OnlineBookStoreSpringBoot.model.BookResponseModel;
import com.bjit.OnlineBookStoreSpringBoot.repository.BookRepository;
import com.bjit.OnlineBookStoreSpringBoot.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class BookServiceImp implements BookService {
    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<Object> createBook(BookRequestModel bookRequestModel) {
        Book book = Book.builder()
                .bookName(bookRequestModel.getBookName())
                .authorName(bookRequestModel.getAuthorName())
                .price(bookRequestModel.getPrice())
                .quantity(bookRequestModel.getQuantity())
                .build();
        Book savedBook = bookRepository.save(book);
        BookResponseModel bookResponseModel = BookResponseModel.builder()
                .bookId(savedBook.getBookId())
                .bookName(savedBook.getBookName())
                .authorName(savedBook.getAuthorName())
                .price(savedBook.getPrice())
                .quantity(savedBook.getQuantity())
                .build();
        return new ResponseEntity<>(bookResponseModel, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<Object> getAllBooks() {
        List<Book> BookList = bookRepository.findAll();
        List<BookResponseModel> responseList = new ArrayList<>();
        for (Book book : BookList) {
            BookResponseModel bookResponseModel = BookResponseModel.builder()
                    .bookId(book.getBookId())
                    .bookName(book.getBookName())
                    .authorName(book.getAuthorName())
                    .price(book.getPrice())
                    .quantity(book.getQuantity())
                    .build();
            responseList.add(bookResponseModel);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    public void deleteBooks(Integer bookId) {
        Book book = bookRepository.findByBookId(bookId);
        if (book != null) {
            bookRepository.delete(book);
        }
    }

    public ResponseEntity<Object> bookDetails(Integer bookId) {
        Book book = bookRepository.findByBookId(bookId);
        if (book != null) {
            BookResponseModel bookResponseModel = BookResponseModel.builder()
                    .bookId(book.getBookId())
                    .bookName(book.getBookName())
                    .authorName(book.getAuthorName())
                    .price(book.getPrice())
                    .quantity(book.getQuantity())
                    .build();
            return new ResponseEntity<>(bookResponseModel, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RuntimeException("Nothing Found"), HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Object> getAuthorName(String authorName) {
        List<Book> authorList = bookRepository.findAllByAuthorName(authorName);
        List<BookResponseModel> responseList = new ArrayList<>();
        for (Book book : authorList) {
            BookResponseModel bookResponseModel = BookResponseModel.builder()
                    .bookId(book.getBookId())
                    .bookName(book.getBookName())
                    .authorName(book.getAuthorName())
                    .price(book.getPrice())
                    .quantity(book.getQuantity())
                    .build();
            responseList.add(bookResponseModel);
        }
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    public ResponseEntity<Object> updateBookInfo(Integer bookId, BookRequestModel updateBookModel) {
        Book book = bookRepository.findByBookId(bookId);
        if (book != null) {
            book.setBookName(updateBookModel.getBookName());
            book.setAuthorName(updateBookModel.getAuthorName());
            book.setPrice(updateBookModel.getPrice());
            book.setQuantity(updateBookModel.getQuantity());
            bookRepository.save(book);
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RuntimeException("Doesn't match authorName and book Name"), HttpStatus.BAD_GATEWAY);
    }

    public ResponseEntity<Object> getBookByAuthorName(String authorName, String bookName) {
        Book book = bookRepository.findByAuthorNameAndBookName(authorName, bookName);
        if (book != null) {
            return new ResponseEntity<>(book, HttpStatus.OK);
        }
        return new ResponseEntity<>(new RuntimeException("Doesn't match authorName and book Name"), HttpStatus.BAD_GATEWAY);
    }
}
