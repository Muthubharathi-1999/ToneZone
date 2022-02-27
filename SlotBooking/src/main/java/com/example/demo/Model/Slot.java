package com.example.demo.Model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "slot")
public class Slot {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long slotID;
	private String slotDate;
	private String slotTime;
	private String status;
	private long customerID;
	private long serviceCenterID;
	/**
	 * @return the slotID
	 */
	public long getSlotID() {
		return slotID;
	}
	/**
	 * @param slotID the slotID to set
	 */
	public void setSlotID(long slotID) {
		this.slotID = slotID;
	}
	/**
	 * @return the slotDate
	 */
	public String getSlotDate() {
		return slotDate;
	}
	/**
	 * @param slotDate the slotDate to set
	 */
	public void setSlotDate(String slotDate) {
		this.slotDate = slotDate;
	}
	/**
	 * @return the slotTime
	 */
	public String getSlotTime() {
		return slotTime;
	}
	/**
	 * @param slotTime the slotTime to set
	 */
	public void setSlotTime(String slotTime) {
		this.slotTime = slotTime;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the customerID
	 */
	public long getCustomerID() {
		return customerID;
	}
	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}
	/**
	 * @return the serviceCenterID
	 */
	public long getServiceCenterID() {
		return serviceCenterID;
	}
	/**
	 * @param serviceCenterID the serviceCenterID to set
	 */
	public void setServiceCenterID(long serviceCenterID) {
		this.serviceCenterID = serviceCenterID;
	} 
	
	
}
