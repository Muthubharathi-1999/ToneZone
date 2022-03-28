package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot,Long>{
	

}
