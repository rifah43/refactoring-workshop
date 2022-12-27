package workshop;
import java.util.LinkedList;

class Question {
    LinkedList popQuestions = new LinkedList();
    LinkedList scienceQuestions = new LinkedList();
    LinkedList sportsQuestions = new LinkedList();
    LinkedList rockQuestions = new LinkedList();

    public void addQuestion(){
        for (int i = 0; i < 50; i++) {
            popQuestions.addLast("Pop Question " + i);
            scienceQuestions.addLast(("Science Question " + i));
            sportsQuestions.addLast(("Sports Question " + i));
            rockQuestions.addLast("Rock Question "+ i);
        }
    }
    public Object askQuestion(workshop.Player player) {
        if (player.getCurrentCategory() == "Pop")
            return popQuestions.removeFirst();
        else if (player.getCurrentCategory() == "Science")
            return scienceQuestions.removeFirst();
        else if (player.getCurrentCategory() == "Sports")
            return sportsQuestions.removeFirst();
        else
            return rockQuestions.removeFirst();
    }
}
