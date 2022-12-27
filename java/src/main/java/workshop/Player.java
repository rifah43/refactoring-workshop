package workshop;
class Player{
    private String playerName;
    private int places;
    private int wins;
    private boolean inPenaltyBox;

    Player(String playerName){
        this.playerName=playerName;
        this.places=0;
        this.wins=0;
        this.inPenaltyBox=false;
    }
    public void incrementWin(){
        wins++;
    }
    public void newLocation(int dice){
        places = places + dice;
        if (places > 11)
        {
            places= places - 12;
        }
    }
    public String getCurrentCategory() {
        if (places%4 == 0) return "Pop";
        else if (places %4 == 1) return "Science";
        else if (places%4 == 2) return "Sports";
        else return "Rock";
    }
    public void setPositionInsidePenaltyBox(Boolean inPenaltyBox){
        this.inPenaltyBox=inPenaltyBox;
    }

    public String getPlayerName(){
        return playerName;
    }
    public int getPlace(){
        return places;
    }
    public int getNumberOfWins(){
        return wins;
    }
    public boolean isInPenaltyBox(){
        return inPenaltyBox;
    }
}