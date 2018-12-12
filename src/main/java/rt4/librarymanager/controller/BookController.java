package rt4.librarymanager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import rt4.librarymanager.model.Book;

@Controller
@RequestMapping("/book")
public class BookController {

    @GetMapping("/create")
    public ModelAndView showCreateBookPage(){
        ModelAndView modelAndView = new ModelAndView("/book/create","artifact", Book.builder().build());
        return modelAndView;
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
