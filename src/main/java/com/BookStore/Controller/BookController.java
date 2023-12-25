package com.BookStore.Controller;

import com.BookStore.Pojo.Book;
import com.BookStore.Pojo.MyBookList;
import com.BookStore.Service.BookService;
import com.BookStore.Service.MyBookListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private MyBookListService myBookListService;
    @GetMapping("/")
    public String home(){
        return "home";
    }
    @GetMapping("/book_register")
    public String bookRegister(){
        return "bookRegister";
    }
    @GetMapping("/available_book")
    public ModelAndView getAllBook(){
       List<Book> list = bookService.getAllBook();
       return new ModelAndView("bookList","book",list);
    }

    @PostMapping("/save")
    public String addBook(@ModelAttribute Book b){
        bookService.save(b);
        return "redirect:/available_book";
    }
    @GetMapping("/my_books")
    public String myBookList(Model model){
        List<MyBookList> list = myBookListService.getAllMyBooks();
        model.addAttribute("book",list);
        return "myBookList";
    }

    @RequestMapping("/mylist/{id}")
    public String getMyList(@PathVariable("id") int id){
        Book book = bookService.getBookById(id);
        MyBookList mybook  = new MyBookList();
        mybook.setId(book.getId());
        mybook.setName(book.getName());
        mybook.setAuthor(book.getAuthor());
        mybook.setPrice(book.getPrice());
        myBookListService.save(mybook);
            return "redirect:/my_books";
    }
    @RequestMapping("/editBook/{id}")
    public String editBook(@PathVariable("id") int id,Model model){
          Book book = bookService.getBookById(id);
          model.addAttribute("book",book);
          return "bookEdit";
    }
    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable("id") int id){
          bookService.deleteBook(id);
          return "redirect:/available_book";
    }
}
