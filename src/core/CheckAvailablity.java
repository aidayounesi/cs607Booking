package core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CheckAvailablity {
	
	Hotel h;
	boolean booked;
	
	CheckAvailablity(Hotel h){
		this.h = h;
	}

List<Integer> checkAvailablity(Date Check_InDate,Date Check_OutDate){
		
		List<Integer> i = new ArrayList<Integer>();
		for(Room r: h.room){
		booked = false;
			for(Date d = Check_InDate; d.compareTo(Check_OutDate)<0; d = new Date(d.getTime() + (1000 * 60 * 60 * 24))){
				if(!booked){
				if(r.getBooked().contains(d)){
					booked = true;	
				}
				}else
					break;
			}
			if(!booked)
				i.add(r.getNumber());
		}
	return i;
}

List<Integer> checkAvailablity(Date Check_InDate,Date Check_OutDate, core.RoomType type){
	
	List<Integer> i = new ArrayList<Integer>();
	for(Room r: h.room){
		if(r.getType() == type){
	booked = false;
		for(Date d = Check_InDate; d.compareTo(Check_OutDate)<0; d = new Date(d.getTime() + (1000 * 60 * 60 * 24))){
			if(!booked){
			if(r.getBooked().contains(d)){
				booked = true;	
			}
			}else
				break;
		}
		if(!booked)
			i.add(r.getNumber());
		}
	}
return i;
}

boolean checkAvailablity(Room r,Date Check_InDate,Date Check_OutDate){
	
	booked = false;
	
	for(Date d = Check_InDate; d.compareTo(Check_OutDate)<0; d = new Date(d.getTime() + (1000 * 60 * 60 * 24))){
		if(!booked){
		if(r.getBooked().contains(d)){
			booked = true;
			
		}
	}else
		break;
		
}
	if(!booked)
		return true;
	else
		return false;
	
	}
	
}
