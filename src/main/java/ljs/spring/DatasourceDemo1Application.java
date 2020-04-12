package ljs.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
public class DatasourceDemo1Application implements CommandLineRunner {

	@Autowired
	private DataSource dataSource;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(DatasourceDemo1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
			showConnetcion();
			showData();
	}

	private void showData() {
		System.out.println("---showdata----");
		jdbcTemplate.queryForList("select  * from FOO").forEach(row -> System.out.println(row.toString()));
	}

	private void showConnetcion() throws SQLException {
		System.out.println(dataSource.toString());
		Connection connection = dataSource.getConnection();
		System.out.println(connection.toString());
		connection.close();
	}
}
