package tests;
import source.SessionManager;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SessionManagerTest {

    @Test
    public void testGetOrCreateNewSession() {
        SessionManager manager = new SessionManager();
        UserSession session = manager.getOrCreate("alice");
        assertNotNull(session);
        assertEquals("alice", session.getUserId());
    }

    @Test
    public void testGetOrCreateReturnsSameSession() {
        SessionManager manager = new SessionManager();
        UserSession first = manager.getOrCreate("alice");
        UserSession second = manager.getOrCreate("alice");
        assertSame(first, second);
    }

    @Test
    public void testDifferentUsersDifferentSessions() {
        SessionManager manager = new SessionManager();
        UserSession alice = manager.getOrCreate("alice");
        UserSession bob = manager.getOrCreate("bob");
        assertNotSame(alice, bob);
        assertEquals("alice", alice.getUserId());
        assertEquals("bob", bob.getUserId());
    }

    @Test
    public void testScorePreservedForSameUser() {
        SessionManager manager = new SessionManager();
        UserSession alice = manager.getOrCreate("alice");
        alice.incrementScore();

        UserSession aliceAgain = manager.getOrCreate("alice");
        assertEquals(1, aliceAgain.getScore());
    }
}
