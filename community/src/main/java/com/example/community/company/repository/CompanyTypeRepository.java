package com.example.community.company.repository;

import com.example.community.company.entity.CompanyType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyTypeRepository extends JpaRepository<CompanyType, Long> {
    CompanyType findCompanyTypeByTypeName(String name);
}
