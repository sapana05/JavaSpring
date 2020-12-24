package com.techgig.women.test.Response;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class Building {
private String buildingName;
private String buildingNo;
private List<Floor> floors;
public String getBuildingName() {
	return buildingName;
}
public void setBuildingName(String buildingName) {
	this.buildingName = buildingName;
}
public String getBuildingNo() {
	return buildingNo;
}
public void setBuildingNo(String buildingNo) {
	this.buildingNo = buildingNo;
}
public List<Floor> getFloors() {
	if(floors == null) {
		floors=new ArrayList<>();	
	}
	return floors;
}
public void setFloors(List<Floor> floors) {
	this.floors = floors;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((buildingName == null) ? 0 : buildingName.hashCode());
	result = prime * result + ((buildingNo == null) ? 0 : buildingNo.hashCode());
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
	Building other = (Building) obj;
	if (buildingName == null) {
		if (other.buildingName != null)
			return false;
	} else if (!buildingName.equals(other.buildingName))
		return false;
	if (buildingNo == null) {
		if (other.buildingNo != null)
			return false;
	} else if (!buildingNo.equals(other.buildingNo))
		return false;
	return true;
}


}
