package source;

import java.util.ArrayList;
import java.util.List;

public class QuestionRepository {
    private List<Question> questions = new ArrayList<>();
    
    public QuestionRepository(){
        questions.add(new Question("Какой металл жидкий при комнатной температуре?", "Ртуть"));
        questions.add(new Question("Какая планета ближе всего к Солнцу?", "Меркурий"));
        questions.add(new Question("Столица Франции?", "Париж"));
        questions.add(new Question("Какая планета самая большая в Солнечной системе?", "Юпитер"));
        questions.add(new Question("Сколько сторон у треугольника?", "Три"));
        questions.add(new Question("Самая высокая гора в мире?", "Эверест"));
        questions.add(new Question("Самое глубокое озеро в мире?", "Байкал"));
        questions.add(new Question("Сколько костей в теле взрослого человека?","206"));
    }

    public Question getQuestionByIndex(int i){
        if((i>=0)&&(i<questions.size())){
            return questions.get(i);
        }
        else{
            return null;
        }
    }

    public int getTotalCount(){
        return questions.size();
    }
}

