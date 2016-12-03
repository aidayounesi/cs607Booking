package iterator01;

import java.util.Date;

public class CancelEvent extends Hotel_Event{

	
	void event(Room r , Date Check_InDate, Date Check_OutDate) {
		
		CancelBooking(r , Check_InDate, Check_OutDate);
		
	}
	
	void CancelBooking(Room r , Date Check_InDate, Date Check_OutDate){
		
		for(Date d = Check_InDate; d.compareTo(Check_OutDate)<0; d = new Date(d.getTime() + (1000 * 60 * 60 * 24))){
			r.removeBooked(d);
		}
		
	}

}
