package source;

public class UserSession {
    private String userId;
    private Question currentQuestion;
    private int score;
    private boolean finished;
    private int currentQuestionIndex;

    public UserSession(String userId) {
        this.userId = userId;
        this.score = 0;
        this.finished = false;
        this.currentQuestionIndex = 0;
    }

    public String getUserId() {
        return userId;
    }

    public Question getCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(Question currentQuestion) {//сеттер
        this.currentQuestion = currentQuestion;
    }

    public int getScore() {
        return score;
    }

    public void incrementScore() {//увеличение счета
        this.score++;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {//сеттер
        this.finished = finished;
    }

    public int getCurrentQuestionIndex() {
        return currentQuestionIndex;
    }

    public void incrementQuestionIndex() {//переход к след вопросу
        this.currentQuestionIndex++;
    }
}
