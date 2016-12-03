package core;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Room {

	
	private int number;
	
	private Set<Date> booked = new HashSet<Date>();
	private RoomType type;
	private int price = 100; // base price
	
	Room(int num,RoomType type){
		this.number = num;
		this.type = type;
		
		if(type == RoomType.Single){
			this.price = price;
		}else if(type == RoomType.Double){
			this.price = 2*price - 5;
		}else if(type == RoomType.Studio){
			this.price = 2*price + 50;
		}else if(type == RoomType.Suite){
			this.price = 2*price + 100;
		}
	}
	
	public Integer getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
	public Set<Date> getBooked() {
		return booked;
	}
	public void setBooked(Date booked) {
		this.booked.add(booked);
	}
	
	public void removeBooked(Date dateToRemove){
		if(booked.contains(dateToRemove))
			booked.remove(dateToRemove);
	}
	public RoomType getType() {
		return type;
	}
	////////ImMutable///////
	private void setType(RoomType type) {
		this.type = type;
	}
	public int getPrice() {
		return price;
	}
	////////ImMutable///////
	private void setPrice(int price) {
		
		
	}
	
}

enum RoomType{ Single, Double, Studio, Suite };