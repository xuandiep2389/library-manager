package rt4.librarymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rt4.librarymanager.model.Book;
import rt4.librarymanager.service.BookService;

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
    public ModelAndView showListBook(){
        ModelAndView modelAndView = new ModelAndView("/book/list");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView showEditPage(){
        ModelAndView modelAndView = new ModelAndView(("/book/edit"));
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView showDeletePage(){
        ModelAndView modelAndView = new ModelAndView(("/book/delete"));
        return modelAndView;
    }

}
