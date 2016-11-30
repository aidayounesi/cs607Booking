import java.util.Date;
import java.util.HashMap;
//import java.util.HashSet;
import java.util.Map;
//import java.util.Set;

public class CalanderRate {

	//float priceMultiplier;
	//Set<Date> datesTest = new HashSet<Date>();
	Map<Date,Integer> dates = new HashMap<>();
	
//	public float getPriceMultiplier() {
//		return priceMultiplier;
//	}
//	public void setPriceMultiplier(float priceMultiplier) {
//		this.priceMultiplier = priceMultiplier;
//	}
//	public Set<Date> getDates() {
//		return dates;
//	}
//	public void setDates(Set<Date> dates) {
//		this.dates = dates;
//	}
//	public void addDate(Date d){
//		dates.add(d);
//	}
	public void addDate(Date d,Integer i){
		dates.put(d, i);
	}
	public Map<Date, Integer> getDates() {
		return dates;
	}
	public void setDates(Map<Date, Integer> dates) {
		this.dates = dates;
	}
	public void removeDate(Date d){
		dates.remove(d);
	}
	
}
