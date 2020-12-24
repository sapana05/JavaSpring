package com.techgig.women.test.Repository;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.techgig.women.test.RandomString;
import com.techgig.women.test.Model.RoomModel;

@Repository
@Transactional
public class AvailableRoomRepository {
	@Autowired
	JdbcTemplate jdbc;
	public List<RoomModel> getAvailableRoom(){
		List<RoomModel> response = jdbc.query("select b.Building_No,b.Building_Name,f.Floor_No,R.RoomId,R.Available,R.Booking_Id,R.Room_Size from Building b inner join Floor f on b.Building_No=f.Building_No inner join Room r on r.Floor_No=f.Floor_No where r.Available=? order by b.Building_No ASC",new Object[] {"Y"},new BeanPropertyRowMapper<RoomModel>(RoomModel.class));
		System.out.println(response.get(0).getBuilding_Name());
		return response;		
	}
	
	public RoomModel getRoomForMeeting(int roomSize){
		RoomModel roomModel = jdbc.queryForObject("select b.Building_No,b.Building_Name,f.Floor_No,R.RoomId,R.Available,R.Booking_Id,R.Room_Size from Building b inner join Floor f on b.Building_No=f.Building_No inner join Room r on r.Floor_No=f.Floor_No where r.Available=? AND r.Room_Size=? order by b.Building_No ASC LIMIT 1",new Object[] {"Y",roomSize}, new BeanPropertyRowMapper<RoomModel>(RoomModel.class));
		if (roomModel==null) {
			return null;
		}
		System.out.println(roomModel.getBuilding_Name());
		String bookingId=RandomString.randomAlphaNumeric(roomModel.getRoomId());
		String updtStmt="update  Room set Booking_Id=?,Available=? where RoomId=?";
		jdbc.update(updtStmt, bookingId,"N",roomModel.getRoomId());
		roomModel.setBooking_Id(bookingId);
		return roomModel;
		
	}
	
	public RoomModel bookRoomForMeeting(String roomId){
		RoomModel roomModel = jdbc.queryForObject("select b.Building_No,b.Building_Name,f.Floor_No,R.RoomId,R.Available,R.Booking_Id,R.Room_Size from Building b inner join Floor f on b.Building_No=f.Building_No inner join Room r on r.Floor_No=f.Floor_No where r.RoomId=?",new Object[] {roomId}, new BeanPropertyRowMapper<RoomModel>(RoomModel.class));
		if (roomModel==null) {
			return null;
		}
		System.out.println(roomModel.getBuilding_Name());
		String bookingId=RandomString.randomAlphaNumeric(roomModel.getRoomId());
		String updtStmt="update  Room set Booking_Id=?,Available=? where RoomId=?";
		jdbc.update(updtStmt, bookingId,"N",roomModel.getRoomId());
		roomModel.setBooking_Id(bookingId);
		return roomModel;
	}
	
	public int canceleRoomBooking(String bookingId) {
	  String updtStmt="update  Room set Available=? where Booking_Id=?";
      int update=jdbc.update(updtStmt,"Y",bookingId);
      System.out.println(update);
      return update;
	}
}
