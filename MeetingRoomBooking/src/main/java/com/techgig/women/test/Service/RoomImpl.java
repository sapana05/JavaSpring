package com.techgig.women.test.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techgig.women.test.Model.RoomModel;
import com.techgig.women.test.Repository.AvailableRoomRepository;
import com.techgig.women.test.Repository.CommonValidator;
import com.techgig.women.test.Response.BookedRoomDetails;
import com.techgig.women.test.Response.Building;
import com.techgig.women.test.Response.Floor;
import com.techgig.women.test.Response.MeetingConstant;
import com.techgig.women.test.Response.Response;
import com.techgig.women.test.Response.Rooms;

import io.micrometer.core.instrument.util.StringUtils;

@Service
public class RoomImpl implements Room{
@Autowired
AvailableRoomRepository ar;
@Autowired
CommonValidator commonValidation;
	
	@Override
	public Response<List<Building>> getAvailableRoom() {
		// TODO Auto-generated method stub
		List<Building> response=new ArrayList<Building>();
		try{
		List<RoomModel> roomModels=ar.getAvailableRoom();
		if(roomModels == null || roomModels.size()==0) {
			return new Response<>(null,"Rooms are not available");
		}
		for(RoomModel rm:roomModels) {
			Building bl=new Building();
			bl.setBuildingNo(rm.getBuilding_No());
			bl.setBuildingName(rm.getBuilding_Name());
			Floor fl=new Floor();
			fl.setFloorNum(rm.getFloor_No());
			Rooms r=new Rooms();
			r.setId(rm.getRoomId());
			r.setRoomSize(rm.getRoom_Size());
			int bIndex=response.indexOf(bl);
			if(bIndex !=-1) {
				int fIndex = response.get(bIndex).getFloors().indexOf(fl);
				if(fIndex !=-1) {
					response.get(bIndex).getFloors().get(fIndex).getListRoom().add(r);
				}else {
					fl.getListRoom().add(r);
					response.get(bIndex).getFloors().add(fl);
				}
			}else {
				fl.getListRoom().add(r);
				bl.getFloors().add(fl);
				response.add(bl);
			}
		}
		return new Response<>(response,MeetingConstant.SUCCESS);
		}catch(RuntimeException e) {
			return new Response<>(null,MeetingConstant.RUN_TIME_ERROR);
		}catch(Exception e) {
			return new Response<>(null,MeetingConstant.FATAL_ERROR);
		}
	}

	@Override
	public Response<BookedRoomDetails> getRoomForMeeting(int roomSize) {
		
		if(roomSize!=MeetingConstant.VALUE_4 && roomSize !=MeetingConstant.VALUE_8) {
			return new Response<>(null,"size of room must be either 4 or 8");
		}
		
		BookedRoomDetails response=new BookedRoomDetails();
		RoomModel roomModel=ar.getRoomForMeeting(roomSize);
		
		try{
			if(roomModel == null) {
			return new Response<>(null,"No rooms are available");
		    }
		
			response.setBookingId(roomModel.getBooking_Id());
			response.setBuildingNo(roomModel.getBuilding_No());
			response.setBuildingName(roomModel.getBuilding_Name());
			response.setFloorNo(roomModel.getFloor_No());
			response.setRoomNo(roomModel.getRoomId());
			response.setRoomSize(roomModel.getRoom_Size());
			response.setBookingStatus("SUCCESSFUL");
		   return new Response<>(response,MeetingConstant.SUCCESS);
	}catch(RuntimeException e) {
		return new Response<>(null,MeetingConstant.RUN_TIME_ERROR);
	}catch(Exception e) {
		return new Response<>(null,MeetingConstant.FATAL_ERROR);
	}
	}

	@Override
	public Response<String> canceleRoomBooking(String bookingId) {
		if(bookingId==null|| StringUtils.isBlank(bookingId)) {
			return new Response<>(null,"booking id can't be null please enter valid booking id");
		}
		if(bookingId != null && !commonValidation.isValidBookingId(bookingId)) {
			return new Response<>(null,MeetingConstant.INVALID_BOOKING_ID);
		}
		int count=ar.canceleRoomBooking(bookingId);
		try {
		if(count>0)
			 return new Response<>("Booking has been cancelled now",MeetingConstant.SUCCESS);
		}catch(RuntimeException e) {
			return new Response<>(null,MeetingConstant.RUN_TIME_ERROR);
		}catch(Exception e) {
			return new Response<>(null,MeetingConstant.FATAL_ERROR);
		}
		return new Response<>(null,"Opps Something went wrong please try again");
	}

	@Override
	public Response<BookedRoomDetails> bookRoomForMeeting( String roomId) {
		if(roomId == null || StringUtils.isBlank(roomId)) {
			return new Response<>(null,"room id can't be null please enter valid room id");
		}
		if(roomId !=null && !commonValidation.isValidRoomId(roomId)) {
			return new Response<>(null,MeetingConstant.INVALID_ROOMID);
		}
		if(!commonValidation.isRoomAvailableForBooking(roomId)) {
			return new Response<>(null,MeetingConstant.ROOM_NOT_AVAILABLE);
		}
		BookedRoomDetails response=new BookedRoomDetails();
		try{
			RoomModel roomModel=ar.bookRoomForMeeting(roomId);
			if(roomModel == null) {
			return new Response<>(null,"No rooms are available");
		    }
		
			response.setBookingId(roomModel.getBooking_Id());
			response.setBuildingNo(roomModel.getBuilding_No());
			response.setBuildingName(roomModel.getBuilding_Name());
			response.setFloorNo(roomModel.getFloor_No());
			response.setRoomNo(roomModel.getRoomId());
			response.setRoomSize(roomModel.getRoom_Size());
			response.setBookingStatus("SUCCESSFUL");
		   return new Response<>(response,MeetingConstant.SUCCESS);
	}catch(RuntimeException e) {
		return new Response<>(null,MeetingConstant.RUN_TIME_ERROR);
	}catch(Exception e) {
		return new Response<>(null,MeetingConstant.FATAL_ERROR);
	}
	}

}
