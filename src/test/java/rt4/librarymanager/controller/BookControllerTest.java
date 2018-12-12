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

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {

    @InjectMocks
    private BookController bookController;

    @Autowired
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {

    }

//    @Test
//    public void testShowBookList() throws Exception{
//        assertNotNull(mockMvc);
//        assertNotNull(bookController);
//        mockMvc.perform(get("/book/list"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
////        .andExpect(model().attribute("artifact", book));
//    }
//    @Test
//    public void testShowCreateBookPage() throws Exception{
//        assertNotNull(mockMvc);
//        assertNotNull(bookController);
//        Book book = Book.builder().build();
//        mockMvc.perform(get("/book/create"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//    }
//
//    @Test
//    public void testCreateBook() throws Exception{
//        assertNotNull(mockMvc);
//        assertNotNull(bookController);
//        Book book = Book.builder().build();
//        mockMvc.perform(post("/book/create"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//    }
//
//
//    @Test
//    public void testShowEditBookPage() throws Exception{
//        assertNotNull(mockMvc);
//        assertNotNull(bookController);
//        mockMvc.perform(get("/book/edit/{id}"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//    }
//
//    @Test
//    public void testEditBook() throws Exception{
//        assertNotNull(mockMvc);
//        assertNotNull(bookController);
//        mockMvc.perform(post("/book/edit"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//    }
//
//    @Test
//    public void testShowDeleteBookPage() throws Exception{
//        assertNotNull(mockMvc);
//        assertNotNull(bookController);
//        mockMvc.perform(post("/book/delete"))
//                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//    }

    @Test
    public void showCreateBookPage() throws Exception{
        assertNotNull(mockMvc);
        assertNotNull(bookController);
        mockMvc.perform(get("/book/create"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

    @Test
    public void createBook() throws Exception {
        assertNotNull(mockMvc);
        assertNotNull(bookController);
        mockMvc.perform(post("/book/create"))
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
    }

//    @Test
//    public void listBook() {
//    }
//
//    @Test
//    public void showEditForm() {
//    }
//
//    @Test
//    public void editBook() {
//    }
//
//    @Test
//    public void viewDeleteForm() {
//    }
//
//    @Test
//    public void deleteBook() {
//    }
}