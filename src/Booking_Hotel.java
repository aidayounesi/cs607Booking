import java.io.EOFException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Booking_Hotel {

	private int number;
	private String CustomerName;
	private String CustomerEmailID;
	private boolean isPaid;
	private Date Check_InDate;
	private Date Check_OutDate;
	private int price;
	 List<Room> room = new ArrayList<Room>();
	List<Room> roomInit;
	{
		roomInit = new ArrayList<Room>();
		roomInit.add(new Room(1,RoomType.Single));
		roomInit.add(new Room(2,RoomType.Single));
		roomInit.add(new Room(3,RoomType.Single));
		roomInit.add(new Room(4,RoomType.Double));
		roomInit.add(new Room(5,RoomType.Double));
		roomInit.add(new Room(6,RoomType.Double));
		roomInit.add(new Room(7,RoomType.Studio));
		roomInit.add(new Room(8,RoomType.Studio));
		roomInit.add(new Room(9,RoomType.Studio));
		roomInit.add(new Room(10,RoomType.Suite));
		roomInit.add(new Room(11,RoomType.Suite));
		roomInit.add(new Room(12,RoomType.Suite));
	}
	Booking_Hotel(){
		
		setRoom(roomInit);
		
	}
	
	////////Mutable///////
	public List<Room> getRoom() {
		return room;
	}
	////////ImMutable///////
	private void setRoom(List<Room> room) {
		this.room = room;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public String getCustomerEmailID() {
		return CustomerEmailID;
	}
	public void setCustomerEmailID(String customerEmailID) {
		CustomerEmailID = customerEmailID;
	}
	public boolean isPaid() {
		return isPaid;
	}
	public void setPaid(boolean isPaid) {
		this.isPaid = isPaid;
	}
	public Date getCheck_InDate() {
		return Check_InDate;
	}
	public void setCheck_InDate(Date check_InDate) {
		Check_InDate = check_InDate;
	}
	public Date getCheck_OutDate() {
		return Check_OutDate;
	}
	public void setCheck_OutDate(Date check_OutDate) {
		if(Check_InDate == null)
			new EOFException();
		Check_OutDate = check_OutDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int NumberOfDaysBooked(){
		return 0;
	}
	
	List<Integer> checkAvailablity(){
		
		List<Integer> i = new ArrayList<Integer>();
		
		for(Room r: room){
			if(r.getBooked().contains(Check_InDate) || r.getBooked().contains(Check_OutDate)){
				continue;
			}
			i.add(r.getNumber());
		}
		return i;
		
	}
	void makeBooking(Room r){
		for(Date d = Check_InDate; d.compareTo(Check_OutDate)<0; d = new Date(d.getTime() + (1000 * 60 * 60 * 24))){
			r.setBooked(d);
		}
	}
	
}
