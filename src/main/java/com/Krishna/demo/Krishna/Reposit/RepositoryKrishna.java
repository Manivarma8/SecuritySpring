package com.Krishna.demo.Krishna.Reposit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Krishna.demo.Krishna.Entity.KrishnaGym;
import com.Krishna.demo.Krishna.Validation.ModelUi;

@Repository
public interface RepositoryKrishna extends JpaRepository<KrishnaGym,Long>{

	

}
