package tests;
import source.UserSession;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UserSessionTest {

    @Test
    public void testInitialState() {
        UserSession session = new UserSession("alice");
        assertEquals("alice", session.getUserId());
        assertEquals(0, session.getScore());
        assertFalse(session.isFinished());
        assertEquals(0, session.getCurrentQuestionIndex());
        assertNull(session.getCurrentQuestion());
    }

    @Test
    public void testIncrementScore() {
        UserSession session = new UserSession("alice");
        session.incrementScore();
        session.incrementScore();
        assertEquals(2, session.getScore());
    }

    @Test
    public void testIncrementQuestionIndex() {
        UserSession session = new UserSession("alice");
        session.incrementQuestionIndex();
        assertEquals(1, session.getCurrentQuestionIndex());
    }

    @Test
    public void testSetFinished() {
        UserSession session = new UserSession("alice");
        session.setFinished(true);
        assertTrue(session.isFinished());
    }
}
