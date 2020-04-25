package web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import web.repository.*;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public TimeTableRepository tableTimeRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new TimeTableRepositoryImpl(jdbcTemplate, namedParameterJdbcTemplate);
    }
    @Bean
    public UniversitiesRepository universityRepository(JdbcTemplate jdbcTemplate) {
        return new UniversitiesRepositoryImpl(jdbcTemplate);
    }
    @Bean
    public FacultiesRepository facultiesRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new FacultiesRepositoryImpl(namedParameterJdbcTemplate);
    }
    @Bean
    public SpecialitiesRepository specialityRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new SpecialitiesRepositoryImpl(namedParameterJdbcTemplate);
    }

    @Bean
    public GroupsRepository groupsRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new GroupsRepositoryImpl(namedParameterJdbcTemplate);
    }

    @Bean
    public UserRepository emailRepository(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        return new UserRepositoryImpl(jdbcTemplate, namedParameterJdbcTemplate);
    }
}
