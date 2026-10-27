package source;

public class Main {
    public static void main(String[] args) {
        // Создаем объекты Человека 1 (если он их уже написал)
        QuestionRepository repository = new QuestionRepository();
        SessionManager sessionManager = new SessionManager();

        // Создаем объекты Человека 2 (ваши)
        QuizLogic quizLogic = new QuizLogic(repository);

        String userId = (args.length > 0) ? args[0] : "default-user";

        // Запускаем интерфейс
        ConsoleUI ui = new ConsoleUI(quizLogic, sessionManager, userId);
        ui.run();
    }
}

