package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Slot;

public interface SlotService {

	public Slot displaySlot(long slotID);
	
	public List<Slot> displayAllSlot();
	
	public void deleteSlot(long slotID);
	
	public Slot storeSlot(Slot slot);
	
	public Slot updateSlot(Slot slot);
}
