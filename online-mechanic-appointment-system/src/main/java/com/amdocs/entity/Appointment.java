package com.amdocs.entity;

public class Appointment extends Object{
	private int appointmentId;
	private int customerId;
	private int mechanicId;
	private String date;
	private String time;
	private int serviceId;
	

	public int getAppointmentId() {
		return appointmentId;
	}


	public void setAppointmentId(int id) {
		this.appointmentId = id;
	}


	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getMechanicId() {
		return mechanicId;
	}


	public void setMechanicId(int mechanicId) {
		this.mechanicId = mechanicId;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public int getServiceId() {
		return serviceId;
	}


	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}


	@Override
	public String toString() {
		return "Appointment Details [id=" + appointmentId + ", customerId=" + customerId + ", mechanicId="
				+ mechanicId + ", date=" + date+ ", time=" + time + ",serviceType="+ serviceId +" ]";
	}
}
