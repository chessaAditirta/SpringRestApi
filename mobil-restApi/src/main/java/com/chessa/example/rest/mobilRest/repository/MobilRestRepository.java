package com.chessa.example.rest.mobilRest.repository;


import com.chessa.example.rest.mobilRest.model.MobilRest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MobilRestRepository extends JpaRepository<MobilRest, Long>{
}
