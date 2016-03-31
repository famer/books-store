package demo;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;


@Configuration
@ComponentScan({"controller", "demo"})
@EnableAutoConfiguration
public class BookToolApplication {
	
	private static final String CREATE_BOOKS_SQL = "CREATE TABLE IF NOT EXISTS books ("+
            "id int not null auto_increment primary key,"+
            "title VARCHAR(256),"+
            "client VARCHAR(256),"+
            "description VARCHAR(256),"+
            "technical_details VARCHAR(256),"+
            "owner VARCHAR(256),"+
            "developer VARCHAR(256),"+
            "deployer VARCHAR(256),"+
            "status VARCHAR(256),"+
            "justification VARCHAR(256),"+
            "classification VARCHAR(256),"+
            "output VARCHAR(256),"+
            "suggested_procedure VARCHAR(256),"+
            "applicable_platforms VARCHAR(256),"+
            "comments VARCHAR(256),"+
            "operating_procedures TEXT,"+
            "test_cases TEXT,"+
            "appendix VARCHAR(256),"+
            "odt_link VARCHAR(256),"+
            "activation_start_date timestamp,"+
            "activation_end_date timestamp"+
            ");";
	
	private static final String CREATE_BOOKS_PARAMETERS_SQL = "CREATE TABLE IF NOT EXISTS book_parameters ("+
            "id int not null auto_increment primary key,"+
            "book_id int,"+
			"title VARCHAR(256),"+
            "description VARCHAR(256),"+
            "type VARCHAR(256),"+
            "value VARCHAR(256)"+
            ");";
	
	private static final String CREATE_BOOKS_MATCHERS_SQL = "CREATE TABLE IF NOT EXISTS book_matchers ("+
            "id int not null auto_increment primary key,"+
            "book_id int,"+
			"matcher VARCHAR(256),"+
            "field VARCHAR(256)"+
            ");";

	@Autowired
    private DataSource dataSource;

    @PostConstruct
    public void setUpTokenDatasource() {
        //JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        //jdbcTemplate.execute(CREATE_BOOKS_SQL);
        //jdbcTemplate.execute(CREATE_BOOKS_PARAMETERS_SQL);
        //jdbcTemplate.execute(CREATE_BOOKS_MATCHERS_SQL);
        
    }

    public static void main(String[] args) {
        SpringApplication.run(BookToolApplication.class, args);
    }
}
