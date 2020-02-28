package whu.csy.test_1.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import whu.csy.test_1.entity.Book;
import whu.csy.test_1.service.BookService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
@Api(value = "BookController",tags = "书籍控制类")//标注在controller类上面
//rest: restful风格
//controller：控制器
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ApiOperation(
            value = "获取所有书籍",
            notes = "获取所有书籍信息"
    )
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }


    @GetMapping(value = "/one") //路径和获取所有书不同
    @ApiOperation(
            value = "按id获取单个书籍",
            notes = "根据id获取单个书籍，id为整数，查到则返回实体，查不到返回null"
    )
    @ApiImplicitParam(value = "书籍号", name = "id",paramType = "query")
    public Book getById(@RequestParam("id") int id){
        return bookService.getBookById(id);
    }

    //根据名字获取
    @GetMapping(value = "/name")
    @ApiOperation(
            value = "按名字获取所有书籍",
            notes = "按名字获取所有书籍信息，返回所有重名书籍"
    )
    @ApiImplicitParam(value = "书籍名", name = "name",paramType = "query")
    public List<Book> getByName(@RequestParam("name") String name){
        return bookService.getBookByName(name);
    }


    @PostMapping(value = "/")
    @ApiOperation(
            value = "增加一本书籍",
            notes = "增加一本书籍"
    )
    public void insertBook(@RequestBody Book book){
        bookService.insertBook(book);

    }

    //根据id删掉一本书
    @DeleteMapping(value = "/{id}") //参数放到路径里

    @ApiOperation(
            value = "按id删除一本书",
            notes = "根据id删除一本书籍，id为整数"
    )
    @ApiImplicitParam(value = "书籍号", name = "id",paramType = "path")
    public void deleteById(@PathVariable("id")int id){
        bookService.deleteBook(id);
    }


    @PutMapping(value = "/")
    @ApiOperation(
            value = "更新一本书籍",
            notes = "更新一本书籍"
    )
    public void updateBook(@RequestBody Book book){
        bookService.updateBook(book);
    }

}
