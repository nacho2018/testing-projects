
public class TestCard {

	Card clubsAce = Card.CLUBS_ACE;
	Card diamondsAce = Card.DIAMONDS_ACE;
	Card heartsAce = Card.HEARTS_ACE;
	Card spadesAce = Card.SPADES_ACE;
	
	public static void main(String[] args){
		
		String sRank = "diamonds";
	
		for (Card card : Card.values()){
			
			if (card.getRank().equals(sRank)){
				System.out.println(card.getRank() + ", " + card.getValue());
				break;
			}
			
		}
	}
}
