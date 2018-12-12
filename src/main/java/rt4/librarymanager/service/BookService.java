package rt4.librarymanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rt4.librarymanager.model.Book;

public interface BookService {
    Page<Book> findAll(Pageable pageable);

    void save(Book book);

    Book findById(int id);

    void remove(int id);

    Page<Book> findAllByName(String name, Pageable pageable);

    Page<Book> findAllByAuthor(String author,Pageable pageable);

}