package com.techgig.women.test.Controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.techgig.women.test.Response.BookedRoomDetails;
import com.techgig.women.test.Response.Building;
import com.techgig.women.test.Response.Response;
import com.techgig.women.test.Response.ResponseHelperWithHTTP;
import com.techgig.women.test.Service.Room;

@RestController
@RequestMapping("/meetingRoomBooking")
public class RoomsController {
	
	
	@Autowired
	Room roomService;
	
	@GetMapping("/availableRooms")
	public ResponseEntity<Response<List<Building>>> getavailableRoom() {
		Response<List<Building>> response=roomService.getAvailableRoom();
		System.out.println(response.getData());
		return new ResponseEntity<>(response,ResponseHelperWithHTTP.getHttpStatus(response.getErrorMsg()));
	}

	@GetMapping("/getRoomForMeeting")
	public ResponseEntity<Response<BookedRoomDetails>> getRoomForMeeting(@RequestParam(required=true) int roomSize) {
		Response<BookedRoomDetails> response= roomService.getRoomForMeeting(roomSize);
		return new ResponseEntity<>(response,ResponseHelperWithHTTP.getHttpStatus(response.getErrorMsg()));
	}
	
	@GetMapping("/bookRoomForMeeting")
	public ResponseEntity<Response<BookedRoomDetails>> getRoomForMeeting(@RequestParam(required=true) String roomId) {
		Response<BookedRoomDetails> response= roomService.bookRoomForMeeting(roomId);
		return new ResponseEntity<>(response,ResponseHelperWithHTTP.getHttpStatus(response.getErrorMsg()));
	}
	
	@GetMapping("/canceleRoomBooking")
	public ResponseEntity<Response<String>> canceleRoomBooking(@RequestParam(required=true) String bookingId) {
		Response<String> response= roomService.canceleRoomBooking(bookingId);
		return new ResponseEntity<>(response,ResponseHelperWithHTTP.getHttpStatus(response.getErrorMsg()));
	}

}
