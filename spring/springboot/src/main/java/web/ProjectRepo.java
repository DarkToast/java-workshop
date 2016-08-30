package web;

import org.h2.store.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ProjectRepo {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProjectRepo(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    public void save(Project project) {
        jdbcTemplate.update("INSERT INTO Projects VALUES (?, ?)", project.getUuid(), project.getName());
    }

}
