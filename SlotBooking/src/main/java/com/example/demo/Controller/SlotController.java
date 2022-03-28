package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Slot;
import com.example.demo.Service.SlotService;

@RestController
public class SlotController {
	
	@Autowired
	private SlotService slotservice;
	
	@GetMapping("/display")
	public Slot displaySlotByID(@RequestParam long slotID) {
		return slotservice.displaySlot(slotID);
	}
	
	@GetMapping("/diplayAll")
	public List<Slot> displayAllSlots(){
		return slotservice.displayAllSlot();
	}
	
	@DeleteMapping("/delete")
	public void deleteSlot(@RequestParam long slotID) {
		slotservice.deleteSlot(slotID);
	}
	
	@PostMapping(path="/store", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public Slot storeSlot(@RequestBody Slot slot) {
		return slotservice.storeSlot(slot);
	}
	
	@PutMapping("/update")
	public Slot updateSlot(@RequestBody Slot slot) {
		return slotservice.updateSlot(slot);
	}

}
