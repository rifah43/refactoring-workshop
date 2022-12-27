package workshop;

import java.util.ArrayList;

public class TriviaGame {
    ArrayList<Player> players = new ArrayList<Player>();
    Question question =new Question();
    int currentPlayer = 0;
    private boolean isOutOfPenaltyBox;

    public TriviaGame() {
        question.addQuestion();
    }
    private boolean isPlayable() {
        return (players.size() >= 2);
    }

    private boolean addPlayer(String playerName) {
        Player player=new Player(playerName);
        players.add(player);
        return true;
    }
    private void rollDice(int dice) {
        announceMessage(players.get(currentPlayer).getPlayerName() + " is the current player");
        announceMessage("They have rolled a " + dice);
        if (players.get(currentPlayer).isInPenaltyBox()) {
            if (dice % 2 != 0) {
                isOutOfPenaltyBox =true;
                changeLocationAndAskQuestion(dice);
            }else {
                announceMessage(players.get(currentPlayer).getPlayerName() + " is not getting out of the penalty box");
                isOutOfPenaltyBox =false;
            }
        } else {
            changeLocationAndAskQuestion(dice);
        }
    }
    public void changeLocationAndAskQuestion(int dice){
        players.get(currentPlayer).newLocation(dice);
        announceMessage(players.get(currentPlayer).getPlayerName()
                + "'s new location is "
                + players.get(currentPlayer).getPlace());
        announceMessage("The category is " + players.get(currentPlayer).getCurrentCategory());
        announceMessage(question.askQuestion(players.get(currentPlayer)));
    }
    public boolean rightAnswered() {
        if (players.get(currentPlayer).isInPenaltyBox()) {
            if (isOutOfPenaltyBox) {
                return addPointsAndReturnWinner();
            } else {
                nextPlayerTurn();
                return true;
            }
        } else {
            return addPointsAndReturnWinner();
        }
    }
    public boolean addPointsAndReturnWinner(){
        announceMessage("Answer was correct!!!!");
        players.get(currentPlayer).incrementWin();
        announceMessage(players.get(currentPlayer)
                + " now has "
                + players.get(currentPlayer).getNumberOfWins()
                + " Gold Coins.");
        boolean winner = didPlayerWin();
        nextPlayerTurn();
        return winner;
    }
    public boolean wrongAnswer() {
        announceMessage("Question was incorrectly answered");
        announceMessage(players.get(currentPlayer) + " was sent to the penalty box");
        players.get(currentPlayer).setPositionInsidePenaltyBox(true);
        nextPlayerTurn();
        return true;
    }
    public void nextPlayerTurn(){
        currentPlayer++;
        if (currentPlayer == players.size()) currentPlayer = 0;
    }

    private boolean didPlayerWin() {
        return !(players.get(currentPlayer).getNumberOfWins()== 6);
    }

    protected void announceMessage(Object message) {
        System.out.println(message);
    }
}