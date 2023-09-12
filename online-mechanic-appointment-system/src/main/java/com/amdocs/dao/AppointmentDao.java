package com.amdocs.dao;

import java.sql.SQLException;
import java.util.List;

import com.amdocs.entity.Appointment;

public interface AppointmentDao {
	
	boolean bookAppointment(Appointment appointment) throws SQLException;
	
	boolean modifyAppointment(int appointmentId, Appointment appointment) throws SQLException;
	
	boolean deleteAppointment(int appointmentId) throws SQLException;
	
	List<Appointment> viewAppointment(int customerId) throws SQLException;
	
	List<Appointment> viewAllAppointment() throws SQLException;

	
}
