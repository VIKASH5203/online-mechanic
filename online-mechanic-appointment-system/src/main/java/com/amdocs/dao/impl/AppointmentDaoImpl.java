package com.amdocs.dao.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.amdocs.dao.AppointmentDao;
import com.amdocs.entity.Appointment;
import com.amdocs.util.DBUtil;

public class AppointmentDaoImpl implements AppointmentDao{
	
	private static final String INSERT_APPOINTMENT="insert into appointments(appointment_id,customer_id,mechanic_id,appointment_date, appointment_time,service_id) values(?,?,?,?,?,?)";
	private static final String DELETE_APPOINTMENT_BY_ID = "DELETE FROM appointments WHERE appointment_id = ?";
	private static final String SELECT_ALL_APPOINTMENTS = "SELECT * FROM appointments";
	private static final String SELECT_APPOINTMENTS_BY_CUSTOMER_ID = "SELECT * FROM appointments WHERE customer_id = ?";
	private static final String UPDATE_APPOINTMENT = "UPDATE appointments SET customer_id=?, mechanic_id=?, appointment_date=?, appointment_time=?, service_id=? WHERE appointment_id=?";
//	private static final String SEARCH_BY_SERVICEID="SELECT service From services WHERE service_id = ?";
	private  Connection connection=DBUtil.getConnection();

	@Override
	public boolean bookAppointment(Appointment appointment) throws SQLException {
		PreparedStatement ps=connection.prepareStatement(INSERT_APPOINTMENT);
//		PreparedStatement ps1=connection.prepareStatement(SEARCH_BY_SERVICEID);
		// Set The value
		ps.setInt(1, appointment.getAppointmentId());
		ps.setInt(2, appointment.getCustomerId());
		ps.setInt(3, appointment.getMechanicId());
		ps.setString(4, appointment.getDate());
		ps.setString(5, appointment.getTime());
		ps.setInt(6, appointment.getServiceId());
//		ps.setString(7, SEARCH_BY_SERVICEID);
		
		//Execute Statement
		int executeUpdate = ps.executeUpdate();
		ps.close();
		if(executeUpdate>0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean modifyAppointment(int appointmentId, Appointment newAppointment) throws SQLException {
	    
	    PreparedStatement ps = connection.prepareStatement(UPDATE_APPOINTMENT);
	    
	    ps.setInt(1, newAppointment.getCustomerId());
	    ps.setInt(2, newAppointment.getMechanicId());
	    ps.setString(3, newAppointment.getDate());
	    ps.setString(4, newAppointment.getTime());
	    ps.setInt(5, newAppointment.getServiceId());
	    ps.setInt(6, appointmentId); // Update the appointment with the given appointmentId
	    
	    int executeUpdate = ps.executeUpdate();
	    
	    if (executeUpdate > 0) {
	        return true; // Successfully modified the appointment
	    }
	    
	    return false; // Failed to modify the appointment
	}



	public boolean deleteAppointment(int appointmentId) throws SQLException {
	    
	    PreparedStatement ps = connection.prepareStatement(DELETE_APPOINTMENT_BY_ID);
	    ps.setInt(1, appointmentId);
	    
	    int rowsAffected = ps.executeUpdate();
	    
	    // Close the PreparedStatement.
	    if (ps != null) {
	        ps.close();
	    }
	    return rowsAffected > 0;
	}

	@Override
	public List<Appointment> viewAppointment(int customerId) throws SQLException {
		
		    List<Appointment> appointments = new ArrayList<>();
		    
		    PreparedStatement ps = connection.prepareStatement(SELECT_APPOINTMENTS_BY_CUSTOMER_ID);
		    ps.setInt(1, customerId);
		    
		    ResultSet resultSet = ps.executeQuery();
		    
		    while (resultSet.next()) {
		        Appointment appointment = new Appointment();
		        appointment.setAppointmentId(resultSet.getInt("appointment_id"));
		        appointment.setCustomerId(resultSet.getInt("customer_id"));
		        appointment.setMechanicId(resultSet.getInt("mechanic_id"));
		        appointment.setDate(resultSet.getString("appointment_date"));
		        appointment.setTime(resultSet.getString("appointment_time")+resultSet.getString("service"));
		        appointment.setServiceId(resultSet.getInt("service_id"));
		        
		        appointments.add(appointment);
		    }
		    
		    // Close the resources explicitly.
		    if (resultSet != null) {
		        resultSet.close();
		    }
		    if (ps != null) {
		        ps.close();
		    }
		    return appointments;
		}

	@Override
	public List<Appointment> viewAllAppointment() throws SQLException {
	    List<Appointment> appointments = new ArrayList<>();
	   
	    PreparedStatement ps = connection.prepareStatement(SELECT_ALL_APPOINTMENTS);
	    ResultSet resultSet = ps.executeQuery();
	    
	    while (resultSet.next()) {
	        Appointment appointment = new Appointment();
	        appointment.setAppointmentId(resultSet.getInt("appointment_id"));
	        appointment.setCustomerId(resultSet.getInt("customer_id"));
	        appointment.setMechanicId(resultSet.getInt("mechanic_id"));
	        appointment.setDate(resultSet.getString("appointment_date"));
	        appointment.setTime(resultSet.getString("appointment_time"));
	        appointment.setServiceId(resultSet.getInt("service_id"));
	        
	        appointments.add(appointment);
	    }
	    
	    // Close the resources explicitly.
	    if (resultSet != null) {
	        resultSet.close();
	    }
	    if (ps != null) {
	        ps.close();
	    }
	    return appointments;
	}


}