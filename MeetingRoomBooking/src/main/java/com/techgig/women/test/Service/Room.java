package com.techgig.women.test.Service;
import java.util.List;

import com.techgig.women.test.Response.BookedRoomDetails;
import com.techgig.women.test.Response.Building;
import com.techgig.women.test.Response.Response;


public interface Room {

	public Response<List<Building>> getAvailableRoom();
	public Response<BookedRoomDetails> getRoomForMeeting(int roomSize);
	public Response<BookedRoomDetails> bookRoomForMeeting(String roomId);
	public Response<String> canceleRoomBooking(String bookingId);
}
