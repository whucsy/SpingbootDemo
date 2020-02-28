package whu.csy.test_1.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import whu.csy.test_1.Repository.BookRepository;

import whu.csy.test_1.entity.Book;

import java.util.List;

@SpringBootTest
public class BookRepositoryTest {

    @Autowired
    BookRepository bookRepository;

    @Test
    public void testGetByPrice(){
        double price = 5;
        List<Book> books = bookRepository.getByPrice(price);
        System.out.println(books);
    }
}
