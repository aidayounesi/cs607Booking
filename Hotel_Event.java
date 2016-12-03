package iterator01;

import java.util.Date;

public abstract class Hotel_Event {
	
	//abstract void welcoming_customer();
	abstract void event(Room r , Date Check_InDate, Date Check_OutDate);
	
	void eventcreating(Room r , Date Check_InDate, Date Check_OutDate){
		
		
		event(r ,  Check_InDate,  Check_OutDate);
		
	}

}
