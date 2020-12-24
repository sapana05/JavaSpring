package com.techgig.women.test.Response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Floor {
public String floorNum;
public List<Rooms> listRoom;
public String getFloorNum() {
	return floorNum;
}
public void setFloorNum(String floorNum) {
	this.floorNum = floorNum;
}
public List<Rooms> getListRoom() {
	if(listRoom == null) {
		listRoom = new ArrayList<>();
	}
	return listRoom;
}
public void setListRoom(List<Rooms> listRoom) {
	this.listRoom = listRoom;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((floorNum == null) ? 0 : floorNum.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Floor other = (Floor) obj;
	if (floorNum == null) {
		if (other.floorNum != null)
			return false;
	} else if (!floorNum.equals(other.floorNum))
		return false;
	return true;
}


}
