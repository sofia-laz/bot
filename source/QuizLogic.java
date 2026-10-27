package source;
public class QuizLogic {
    private final QuestionRepository repository;

    public QuizLogic(QuestionRepository repository) {
        this.repository = repository;
    }

    public String getWelcomeMessage() {
        return "Привет! Я бот-викторина.\n" +
                "Я задаю вопросы, а ты отвечай.\n" +
                "Введи '\\help' в любой момент, чтобы получить справку.";
    }

    public String startSession(UserSession session) {
        return askNextQuestion(session);
    }

    public String handleInput(UserSession session, String input) {
        if (input == null || input.trim().isEmpty()) {
            return "Введите ответ.";
        }
        if (input.equalsIgnoreCase("\\help")) {
            return getHelpText();
        }
        if (session.isFinished()) {
            return "Игра окончена. Ваш счет: " + session.getScore();
        }

        Question q = session.getCurrentQuestion();
        if (q == null) {
            return "Нет активного вопроса.";
        }

        StringBuilder response = new StringBuilder();
        //System.out.println("DEBUG: Я ввел [" + input + "], правильный ответ [" + q.getText() + "]");
        if (q.checkAnswer(input)) {
            session.incrementScore();
            response.append("Верно! ");
        } else {
            response.append("Неверно. ");
        }

        response.append(askNextQuestion(session));
        return response.toString();
    }

    private String askNextQuestion(UserSession session) {
        int idx = session.getCurrentQuestionIndex();
        Question next = repository.getQuestionByIndex(idx);
        if (next == null) {
            session.setFinished(true);
            return "Вопросы закончились. Ваш итоговый счет: " + session.getScore();
        }
        session.setCurrentQuestion(next);
        session.incrementQuestionIndex();
        return "\nВопрос: " + next.getText();
    }

    private String getHelpText() {
        return "--- СПРАВКА ---\n" +
                "Я задаю вопросы. Введи ответ и нажми Enter.\n" +
                "Команда '\\help' показывает это сообщение.\n" +
                "----------------";
    }
}

