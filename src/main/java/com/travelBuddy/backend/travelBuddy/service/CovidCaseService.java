package com.travelBuddy.backend.travelBuddy.service;

import java.util.List;

import com.travelBuddy.backend.travelBuddy.entity.CovidCase;
import org.springframework.stereotype.Service;

@Service
public interface CovidCaseService {
    List<CovidCase> findAndGroupCovidCases();
    
    List<CovidCase> findCovidCasesByCaseType(String caseType);
}

