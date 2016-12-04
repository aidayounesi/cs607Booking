package core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;

public abstract class HotelEvent {

	protected int id;
	protected Date checkIn;
	protected Date checkOut;
	protected String userEmail;
	protected ArrayList<Room> rooms;
	protected ArrayList<HotelPricingRule> pricingRules;

	public void start() {
		doEvent();
	}

	protected String askUserEmail() {
		String email = "";

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Enter your email:");
		try {
			email = in.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return email;
	}

	protected double calculatePayment() {
		double payment = 0;
		double multiplier;
		for (Date date = checkIn; date.compareTo(checkOut)<0; date = new Date(date.getTime() + (1000 * 60 * 60 * 24))){
			for ( HotelPricingRule rule : pricingRules ) {
				multiplier = rule.getMultiplier(date);
				for ( Room room : rooms ) {
					payment += room.getBasePrice()*multiplier;
				}
				if ( multiplier != 1 ) //we want to apply only one rule
					break;
			}
		}
		return payment;
	}

	protected abstract void doEvent();

}
