package rt4.librarymanager.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import rt4.librarymanager.model.Book;
import rt4.librarymanager.service.BookService;

import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Autowired
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

    }


    private static Book emptyBook;

    static {
        emptyBook =  Book.builder().build();
    }

    @Test
    public void showCreateBookPage() throws Exception{
        assertNotNull(mockMvc);
        assertNotNull(bookController);
        mockMvc.perform(get("/book/create"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/create"))
                .andExpect(model().attribute("book", emptyBook));
    }

    @Test
    public void createBook() throws Exception {
        assertNotNull(mockMvc);
        assertNotNull(bookController);
        mockMvc.perform(post("/book/create"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void listBook() throws Exception{
        mockMvc.perform(get("/book/list"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/list"));
    }

    @Test
    public void showEditForm() throws Exception{
        mockMvc.perform(get("/book/edit/*"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/edit/*"));
    }

    @Test
    public void editBook() throws Exception{
        mockMvc.perform(post("/book/edit/*"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/edit/*"));
    }

    @Test
    public void viewDeleteForm() throws Exception{
        mockMvc.perform(get("/book/delete/*"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/delete/*"));
    }

    @Test
    public void deleteBook() throws Exception{
        mockMvc.perform(post("/book/delete/*"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/delete/*"));
    }
}