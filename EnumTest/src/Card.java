
public enum Card {

	//diamonds,clubs,hearts and spades aces
	DIAMONDS_ACE("diamonds", 1),
	CLUBS_ACE("clubs", 1),
	HEARTS_ACE("hearts", 1),
	SPADES_ACE("spades", 1);
	
	private final String rank;
	private final int value;
	
	Card(String rank, int value){
		this.rank = rank;
		this.value = value;
	}
	
	String getRank(){
		return this.rank;
	}
	int getValue(){
		return this.value;
	}
	
	
	
}
