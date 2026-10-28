package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuizLogicTest {

    // Вспомогательный метод, чтобы каждый раз не создавать объекты вручную
    private QuizLogic createLogic() {
        QuestionRepository repo = new QuestionRepository();
        return new QuizLogic(repo);
    }

    @Test
    public void testWelcomeMessage() {
        QuizLogic logic = createLogic();
        String welcome = logic.getWelcomeMessage();
        // Проверяем, что приветствие содержит слово "викторина" (игнорируя регистр)
        assertTrue(welcome.toLowerCase().contains("викторина"));
    }

    @Test
    public void testStartSession() {
        QuizLogic logic = createLogic();
        UserSession session = new UserSession("test-user");

        String firstQuestion = logic.startSession(session);

        // Проверяем, что при старте задается вопрос (он не пустой)
        assertNotNull(firstQuestion);
        assertTrue(firstQuestion.contains("Вопрос:"));
        // Также проверяем, что в сессии сохранился текущий вопрос
        assertNotNull(session.getCurrentQuestion());
    }

    @Test
    public void testCorrectAnswer() {
        QuizLogic logic = createLogic();
        UserSession session = new UserSession("test-user");
        logic.startSession(session); // запускаем, чтобы появился первый вопрос

        // Имитируем правильный ответ на первый вопрос напарника (про Ртуть)
        String response = logic.handleInput(session, "Ртуть");

        // Бот должен сказать "Верно", и счет должен увеличиться
        assertTrue(response.contains("Верно"));
        assertEquals(1, session.getScore());
    }

    @Test
    public void testIncorrectAnswer() {
        QuizLogic logic = createLogic();
        UserSession session = new UserSession("test-user");
        logic.startSession(session);

        // Имитируем неправильный ответ
        String response = logic.handleInput(session, "Золото");

        // Бот должен сказать "Неверно", счет не меняется
        assertTrue(response.contains("Неверно"));
        assertEquals(0, session.getScore());
    }

    @Test
    public void testHelpCommand() {
        QuizLogic logic = createLogic();
        UserSession session = new UserSession("test-user");
        logic.startSession(session);

        // Проверяем команду справки
        String response = logic.handleInput(session, "\\help");

        assertTrue(response.contains("СПРАВКА"));
        assertEquals(0, session.getScore()); // Счет не должен меняться
    }

    @Test
    public void testEndOfQuestions() {
        QuizLogic logic = createLogic();
        UserSession session = new UserSession("test-user");
        logic.startSession(session);

        // Отвечаем на все вопросы неправильно, чтобы просто пройти их все
        // (Можно ответить и правильно, логика не важна, важно дойти до конца)
        for (int i = 0; i < 10; i++) {
            if (!session.isFinished()) {
                logic.handleInput(session, "Неважно");
            }
        }

        // Игра должна завершиться
        assertTrue(session.isFinished());
    }
}