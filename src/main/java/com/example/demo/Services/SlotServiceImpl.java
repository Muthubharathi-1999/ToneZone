package com.example.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Slot;
import com.example.demo.Repository.SlotRepository;

@Service
public class SlotServiceImpl implements SlotService {

	@Autowired
	private SlotRepository slotrepository;
	
	@Override
	public Slot displaySlot(long slotID) {
		return slotrepository.findById(slotID).get();
	}

	@Override
	public List<Slot> displayAllSlot() {
		return (List<Slot>) slotrepository.findAll();
	}

	@Override
	public void deleteSlot(long slotID) {
		slotrepository.deleteById(slotID);	
	}

	@Override
	public Slot storeSlot(Slot slot) {
		return slotrepository.save(slot);
	}

	@Override
	public Slot updateSlot(Slot slot) {
		return slotrepository.saveAndFlush(slot);
	}

}
