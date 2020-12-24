package com.techgig.women.test.Model;

import org.springframework.stereotype.Component;

@Component
public class RoomModel {
	private String Building_No;
	private String Building_Name;
	private String Floor_No;
	private String RoomId;
	private String Available;
	private String Booking_Id;
	private int Room_Size;
	public String getBuilding_No() {
		return Building_No;
	}
	public void setBuilding_No(String building_No) {
		Building_No = building_No;
	}
	public String getBuilding_Name() {
		return Building_Name;
	}
	public void setBuilding_Name(String building_Name) {
		Building_Name = building_Name;
	}
	public String getFloor_No() {
		return Floor_No;
	}
	public void setFloor_No(String floor_No) {
		Floor_No = floor_No;
	}
	public String getRoomId() {
		return RoomId;
	}
	public void setRoomId(String roomId) {
		RoomId = roomId;
	}
	public String getAvailable() {
		return Available;
	}
	public void setAvailable(String available) {
		Available = available;
	}
	public String getBooking_Id() {
		return Booking_Id;
	}
	public void setBooking_Id(String booking_Id) {
		Booking_Id = booking_Id;
	}
	public int getRoom_Size() {
		return Room_Size;
	}
	public void setRoom_Size(int room_Size) {
		Room_Size = room_Size;
	}
	

}
