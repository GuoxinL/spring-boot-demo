package pub.guoxin.security.service;

import pub.guoxin.security.model.User;

/**
 * Created by guoxin on 17-8-26.
 */
public interface AuthService {
    User register(User userToAdd);
    String login(String username, String password);
    String refresh(String oldToken);
}
