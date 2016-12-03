package core;

import java.util.Date;

public class BookingEvent extends Hotel_Event{

	@Override
	void event(Room r , Date Check_InDate, Date Check_OutDate) {
		
		
		BlockingRoom( r ,  Check_InDate,  Check_OutDate);
		
	}
	
	void BlockingRoom(Room r , Date Check_InDate, Date Check_OutDate){
		for(Date d = Check_InDate; d.compareTo(Check_OutDate)<0; d = new Date(d.getTime() + (1000 * 60 * 60 * 24))){
			r.setBooked(d);
		}
	}

}
