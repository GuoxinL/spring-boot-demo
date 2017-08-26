package pub.guoxin.security.utils;

import org.springframework.security.core.GrantedAuthority;
import pub.guoxin.security.enums.Role;
import pub.guoxin.security.model.JwtUser;
import pub.guoxin.security.model.User;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by guoxin on 17-8-26.
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(User user) {
        return new JwtUser(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                mapToGrantedAuthorities(user.getRoles()),

                user.getLastPasswordResetDate()
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(List<Role> authorities) {
        //
        return authorities.stream()
                .map(new Function<Role, GrantedAuthority>() {
                    @Override
                    public GrantedAuthority apply(Role role) {
                        return new GrantedAuthority() {
                            @Override
                            public String getAuthority() {
                                return role.toString();
                            }
                        };
                    }
                })
                .collect(Collectors.toList());
    }
}