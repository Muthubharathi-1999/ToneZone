package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.ServiceCenter;
@Repository
public interface ServiceCenterRepository extends JpaRepository<ServiceCenter, Long> {

}