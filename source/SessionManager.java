package source;

import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private final List<UserSession> sessions = new ArrayList<>();

    public SessionManager() {
    }

    public UserSession getOrCreate(String userId) {
        for (UserSession session : sessions) {
            if (session.getUserId().equals(userId)) {
                return session;
            }
        }
        UserSession newSession = new UserSession(userId);
        sessions.add(newSession);
        return newSession;
    }
}