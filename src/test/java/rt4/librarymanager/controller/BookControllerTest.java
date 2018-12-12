package rt4.librarymanager.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
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
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    private static Book emptyBook;
    private static int sampleID;
    private static String sampleName;
    private static String sampleAuthor;
    private static String sampleType;
    private static int sampleAmount;
    private static Book sampleBook;


    static {
        emptyBook =  Book.builder().build();
        sampleID = 1;
        sampleAmount = 1;
        sampleName = "sample name";
        sampleType = "sample type";
        sampleAuthor = "sample author";
        sampleBook = Book.builder()
                .id(sampleID)
                .name(sampleName)
                .author(sampleAuthor)
                .type(sampleType)
                .amount(sampleAmount)
                .build();
    }

    @InjectMocks
    private BookController bookController;

    @Autowired
    private BookService bookService;

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void showCreateBookPage() throws Exception{
        mockMvc.perform(get("/book/create"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/create"));
//                .andExpect(model().attribute("book", emptyBook));
    }

    @Test
    public void createBook() throws Exception {
        mockMvc.perform(post("/book/create"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/create"));
    }

    @Test
    public void listBook() throws Exception{
        mockMvc.perform(get("/book/list"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/list"));
    }

    @Test
    public void showEditForm() throws Exception{
        when(bookService.findById(sampleID))
                .thenReturn(sampleBook);

        mockMvc.perform(get("/book/edit/" + sampleID))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(view().name("/book/edit"))
                .andExpect(model().attribute("book",sampleBook));
    }

    @Test
    public void editBook() throws Exception{
        mockMvc.perform(post("/book/edit"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/edit"));
    }

    @Test
    public void viewDeleteForm() throws Exception{
        mockMvc.perform(get("/book/delete"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/delete"));
    }

    @Test
    public void deleteBook() throws Exception{
        mockMvc.perform(post("/book/delete"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful())
                .andExpect(view().name("/book/delete"));
    }
}