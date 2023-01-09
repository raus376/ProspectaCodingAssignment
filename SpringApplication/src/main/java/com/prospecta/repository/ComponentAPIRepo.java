package com.prospecta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prospecta.models.ComponentAPI;

@Repository
public interface ComponentAPIRepo extends JpaRepository<ComponentAPI,Integer>{

}
