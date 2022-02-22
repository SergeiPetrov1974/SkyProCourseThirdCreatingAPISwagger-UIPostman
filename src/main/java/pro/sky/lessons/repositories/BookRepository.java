package pro.sky.lessons.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pro.sky.lessons.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}
