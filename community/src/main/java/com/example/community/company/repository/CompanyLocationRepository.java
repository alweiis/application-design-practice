package com.example.community.company.repository;

import com.example.community.company.entity.CompanyLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyLocationRepository extends JpaRepository<CompanyLocation, Long> {
    CompanyLocation findCompanyLocationByLocationName(String name);
}
