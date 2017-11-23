package pub.guoxin.security.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Created by guoxin on 17-11-5.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {
    /**
     * 编写CustomUserDetailsService类实现UserDetailsService接口
     * 实现loadUserByUsername()方法将传入的用户名进行数据查询，并返
     * 回经过SecurityUser包装的UserDetails对象
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
