package demo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "Book", path = "books")
public interface BookRepository extends JpaRepository<Book, Long> {
	Page<Book> findAll(Pageable pageable);
	Book findOne(Long aLong);
	List<Book> findByTitle(@Param("title") String title);
	List<Book> findByTitleLike(@Param("title") String title);
	List<Book> findByDeveloperLike(@Param("developer") String developer);
	List<Book> findByOwnerLike(@Param("owner") String owner);
	List<Book> findByDescriptionLike(@Param("description") String description);
}