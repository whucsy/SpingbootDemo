package whu.csy.test_1.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import whu.csy.test_1.entity.Book;

import java.util.List;

//数据库操作接口
public interface BookRepository extends JpaRepository<Book, Integer>
{
    List<Book> findByBookName(String bookName);

    @Query(value = "select * from Book where price = ?1",nativeQuery = true)
    List<Book> getByPrice(double price);

}
