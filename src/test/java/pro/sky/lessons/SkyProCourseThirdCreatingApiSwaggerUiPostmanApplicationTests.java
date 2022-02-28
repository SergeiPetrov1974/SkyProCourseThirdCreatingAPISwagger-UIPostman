package pro.sky.lessons;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import pro.sky.lessons.controllers.BookController;
import pro.sky.lessons.model.Book;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SkyProCourseThirdCreatingApiSwaggerUiPostmanApplicationTests {
    @LocalServerPort
    private int port;

    @Autowired
    private BookController booksController;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void contextLoads() throws Exception {
        Assertions.assertThat(booksController).isNotNull();
    }

    @Test
    public void testDefaultMessage() throws Exception {
        Assertions.assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/", String.class))
                .isEqualTo("WebApp is working!");
    }

    @Test
    public void testGetBooks() throws Exception {
        Assertions.
                assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/books", String.class))
                .isNotNull();
    }

    @Test
    public void testPostBooks() throws Exception {
        Book book = new Book();
        book.setName("Pop");
        book.setAuthor("Popov");
        Assertions.
                assertThat(this.restTemplate.postForObject("http://localhost:" + port + "/books", book, String.class))
                .isNotNull();
    }
}
