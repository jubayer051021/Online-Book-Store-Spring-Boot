package com.bjit.OnlineBookStoreSpringBoot.repository;

import com.bjit.OnlineBookStoreSpringBoot.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {
    Book findByBookId(Integer bookId);
    Book findByBookName(String bookName);
    List<Book> findAllByAuthorName(String authorName);
    Book findByAuthorNameAndBookName(String authorName,String bookName);
}
