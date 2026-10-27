package source;

import java.util.Scanner;


public class ConsoleUI {
    private final QuizLogic quizLogic;
    private final SessionManager sessionManager;
    private final Scanner scanner;
    private final String currentUserId;

    public ConsoleUI(QuizLogic quizLogic, SessionManager sessionManager, String userId) {
        this.quizLogic = quizLogic;
        this.sessionManager = sessionManager;
        this.currentUserId = userId;
        
        // Принудительно указываем сканеру читать ввод в кодировке UTF-8
        this.scanner = new Scanner(System.in, "Cp866");//изменили кодировку
    }

    public void run() {
        UserSession session = sessionManager.getOrCreate(currentUserId);

        System.out.println(quizLogic.getWelcomeMessage());
        System.out.println(quizLogic.startSession(session));

        while (!session.isFinished()) {
            System.out.print("> ");
            String input = scanner.nextLine();
            System.out.println(quizLogic.handleInput(session, input));
        }

        System.out.println("Итоговый счет: " + session.getScore());
    }
}