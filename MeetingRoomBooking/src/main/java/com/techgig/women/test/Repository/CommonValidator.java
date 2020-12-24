package com.techgig.women.test.Repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CommonValidator {
	@Autowired
	JdbcTemplate jdbc;
	
	public boolean isValidBookingId(String bookingId) {
		int count = jdbc.queryForObject("select count(*) From Room r where r.Available=? AND r.Booking_Id = ? ",new Object[] {"N",bookingId},Integer.class);
		return count>0;
	}
	public boolean isValidRoomId(String roomId) {
		int count = jdbc.queryForObject("select count(*) From Room r where r.RoomId = ? ",new Object[] {roomId},Integer.class);
		return count>0;
	}
	
	public boolean isRoomAvailableForBooking(String roomId) {
		int count = jdbc.queryForObject("select count(*) From Room r where r.Available=? AND r.RoomId = ? ",new Object[] {"Y",roomId},Integer.class);
		return count>0;
	}

}
