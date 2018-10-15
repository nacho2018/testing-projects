
public class TestsEnum {

	public static void main(String[] args){
		
		Day day1 = Day.MONDAY;
		Day day2 = Day.WEDNESDAY;
		
		System.out.println(day1.dayMessage());
		System.out.println(day2.dayMessage());
		
		Day day = day1.getFromDescription(day1.toString());
		System.out.println(day.dayMessage());
		
		for (Day theDay : Day.values()){
			System.out.println(theDay.dayMessage());
		}
	}
}
