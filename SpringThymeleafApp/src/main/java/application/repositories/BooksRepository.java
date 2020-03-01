package application.repositories;

import application.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BooksRepository extends CrudRepository<Book, Long> {

}
