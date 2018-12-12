package rt4.librarymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import rt4.librarymanager.model.Book;
import rt4.librarymanager.service.BookService;

import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/create")
    public ModelAndView showCreateBookPage(){
        ModelAndView modelAndView = new ModelAndView("/book/create");
        modelAndView.addObject("book", new Book());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createBook(@Validated @ModelAttribute("book") Book book, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            ModelAndView modelAndView =new ModelAndView("/book/create");
            return modelAndView;
        }else {
            ModelAndView modelAndView = new ModelAndView("/book/create");
            bookService.save(book);
            modelAndView.addObject("message", "New book created succesfully");
            modelAndView.addObject("book", new Book());
            return modelAndView;
        }
    }

    @GetMapping("/list")
    public ModelAndView listBook(@RequestParam("search") Optional<String> search, @PageableDefault(size = 3) Pageable pageable) {
        Page<Book> books;
        if (search.isPresent()) {
            books = bookService.findAllByName(search.get(), pageable);
        } else {
            books = bookService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/book/list");
        modelAndView.addObject("books", books);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        modelAndView.addObject("book", bookService.findById(id));
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editBook(Book book) {
        ModelAndView modelAndView = new ModelAndView("/book/edit");
        bookService.save(book);
        modelAndView.addObject("message", "Book was update successfully");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView showDeletePage(){
        ModelAndView modelAndView = new ModelAndView(("/book/delete"));
        return modelAndView;
    }

}
