package source;

public class Question{
    private final String text;
    private final String correctAnswer;

    public Question(String text,String answer){
        this.text=text;
        this.correctAnswer=answer;
    }

    public String getText(){
        return text;
    }

    public boolean checkAnswer(String userAnswer){
        return (userAnswer.trim().equalsIgnoreCase(correctAnswer));
    }
    
}