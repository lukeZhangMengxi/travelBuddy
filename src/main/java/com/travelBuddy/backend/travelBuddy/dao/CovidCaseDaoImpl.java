package com.travelBuddy.backend.travelBuddy.dao;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;
// import com.travelBuddy.backend.travelBuddy.mapper.CovidCaseMapper;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CovidCaseDaoImpl implements CovidCaseDao {

    private NamedParameterJdbcTemplate template;
    
    public CovidCaseDaoImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<CovidCase> findAndGroupCovidCases() {
        final String sql = new StringBuilder()
                        .append("select longitude, latitude, count(*)")
                        .append(" from covidcase group by (longitude, latitude)")
                        .toString();

        return template.query(sql, new BeanPropertyRowMapper(CovidCase.class));
    }

    @Override
    public List<CovidCase> findCovidCasesByCaseType(String caseType) {
        final String sql = new StringBuilder()
                        .append("select longitude, latitude, count(*)")
                        .append("from covidcase where casetype = ")
                        .append("'" + caseType + "'")
                        .append(" group by (longitude, latitude)")
                        .toString();
        
        return template.query(sql, new BeanPropertyRowMapper(CovidCase.class));
    }
}