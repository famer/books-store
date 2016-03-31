package demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.rest.core.annotation.RestResource;

import com.fasterxml.jackson.annotation.JsonBackReference;



@Entity
@Table(name="book_matchers")
public class BookMatcher {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="book_id")
	@RestResource(rel="book_for_matcher", exported = false)
    private Book book;
	
	@Column(name="matcher")
	public String matcher;

	@Column(name="field")
	public String field;
	
}