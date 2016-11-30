import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		
		Booking_Hotel b= new Booking_Hotel();
		b.setCustomerName("Pravin");
		b.setCustomerEmailID("pravinkumar0999@gmail.com");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String in_dateInString = "01-12-2016 10:20:56";
		String out_dateInString = "05-12-2016 10:20:56";
		Date in_date = null;
		Date out_date = null;
		try {
			in_date = sdf.parse(in_dateInString);
			out_date = sdf.parse(out_dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		b.setCheck_InDate(in_date);
		b.setCheck_OutDate(out_date);
		b.makeBooking(b.room.get(10));
		b.makeBooking(b.room.get(9));
		b.makeBooking(b.room.get(2));
		List<Integer> i=b.checkAvailablity();
		for(Integer r : i){
			System.out.println(r);
		}
		
		System.out.println("\nPrice for room no. 11 is "+ b.room.get(10).getPrice());
		System.out.println("Price for room no. 10 is "+ b.room.get(9).getPrice());
		System.out.println("Price for room no. 1  is "+ b.room.get(2).getPrice());
		System.out.println("Price for room no. 5  is "+ b.room.get(4).getPrice());
		
		 in_dateInString = "06-12-2016 10:20:56";
		 out_dateInString = "07-12-2016 10:20:56";
		 in_date = null;
		 out_date = null;
		try {
			in_date = sdf.parse(in_dateInString);
			out_date = sdf.parse(out_dateInString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		b.setCheck_InDate(in_date);
		b.setCheck_OutDate(out_date);
		System.out.println("\n\n");
		 i=b.checkAvailablity();
		for(Integer r : i){
			System.out.println(r);
		}
		
	}
	
}
