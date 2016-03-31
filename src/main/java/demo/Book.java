package demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity
@Table(name="books")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	private Long id;
	
	@Column(name="title")
	public String title;
	
	@Column(name="client")
	public String client;
		
	@Column(name="description")
	public String description;
	
	@Column(name="technical_details")
	public String technicalDetails;
	
	@Column(name="owner") 
	public String owner;
	
	@Column(name="developer") 
	public String developer;
	
	@Column(name="deployer")
	public String deployer;
	
	@Column(name="status")
	public String status;
	
	@Column(name="justification")
	public String justification;
	
	@Column(name="classification")
	public String classification;
	
	@Column(name="output")
	public String output;
	
	@Column(name="suggested_procedure")
	public String suggestedProcedure;
	
	@Column(name="applicable_platforms")
	public String applicablePlatforms;
	
	@Column(name="comments")
	public String comments;
	
	@Column(name="operating_procedures")
	public String operatingProcedures;
	
	@Column(name="test_cases")
	public String testCases;
	
	@Column(name="appendix")
	public String appendix;
	
	@Column(name="odt_link")
	public String odtLink;
	
	//@Column(name="flowchart")
	//public String flowchart;
	
	@Column(name="activationStartDate")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date activationStartDate = new Date();
	
	@Column(name="activationEndDate")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	public Date activationEndDate = new Date();

	public Book() {}

	
	@JsonManagedReference
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "book", orphanRemoval=true)
	public Set<BookParameter> parameters = new HashSet<>();
	
	public void setParameters(HashSet<BookParameter> set) {
	    if (set != null) {
	        this.parameters.clear();
	        this.parameters.addAll(set);
	    }
	}
	

	@JsonManagedReference
    @OneToMany(cascade = {CascadeType.ALL,CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "book", orphanRemoval=true)
	public Set<BookMatcher> matchers = new HashSet<>();
	
	
	public void setMatchers(HashSet<BookMatcher> set) {
	    if (set != null) {
	        this.matchers.clear();
	        this.matchers.addAll(set);
	    }
	}
	
	
}

