
public enum Day {

	MONDAY(0),
	TUESDAY(1),
	WEDNESDAY(2),
	THURSDAY(3),
	FRIDAY(4),
	SATURDAY(5),
	SUNDAY(6);
	
	Day(int sort){
		this.sort = sort;
	}
	
	private final int sort;
	
	public String dayMessage(){
		
		return "The sort of the day " + this.toString() + " is " + this.sort;
		
	}
	
	public int getSort(){
		
		return this.sort;
	}
	
	Day getFromDescription(String desc){
		
		return Day.valueOf(desc);
	}
	

	
}
