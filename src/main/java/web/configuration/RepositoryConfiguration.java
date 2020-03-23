package web.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import web.repository.*;

@Configuration
public class RepositoryConfiguration {
    @Bean
    public TimeTableRepository tableTimeRepository(JdbcTemplate jdbcTemplate) {
        return new TimeTableRepositoryImpl(jdbcTemplate);
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
    public EmailRepository emailRepository(JdbcTemplate jdbcTemplate) {
        return new EmailRepositoryImpl(jdbcTemplate);
    }
}
