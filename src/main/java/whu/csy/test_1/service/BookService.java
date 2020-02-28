package whu.csy.test_1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import whu.csy.test_1.Repository.BookRepository;
import whu.csy.test_1.entity.Book;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void insertBook(Book book){
        bookRepository.save(book);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

    public void deleteBook(int id){
        bookRepository.deleteById(id);
    }

    public Book getBookById(int id){
        return bookRepository.findById(id).get();
    }

    public List<Book> getBookByName(String name){
        return bookRepository.findByBookName(name);
    }

    public List<Book> getBookByPrice(double price){
        return bookRepository.getByPrice(price);
    }
}
