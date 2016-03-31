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
import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="book_parameters")
public class BookParameter {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	
	@JsonBackReference
    @ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="book_id")
    private Book book;
	
	@Column(name="title")
	public String title;

	@Column(name="description")
	public String description;

	@Column(name="type")
	public String type;
	
	@Column(name="value")
	public String value;
	
}
