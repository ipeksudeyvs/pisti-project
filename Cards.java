public class Cards {
    private String number;
    private String suit;

    public Cards(String suit, String number) {

        this.suit= suit;
        this.number= number;
    }

    public String getNumber () { return number; }
    public String getSuit () { return suit ;}

    public void setNumber( String number) { this.number=number; }
    public void setSuit ( String suit ) { this.suit=suit; }
}
