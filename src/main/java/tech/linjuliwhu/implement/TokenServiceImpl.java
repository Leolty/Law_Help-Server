package tech.linjuliwhu.implement;

import tech.linjuliwhu.domain.Role;
import tech.linjuliwhu.service.TokenService;
import tech.linjuliwhu.util.MyConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    RedisServiceImpl redisService;

    @Override
    public UserDetails authenticateToken(@NonNull String token, String id) {
        Object obj = redisService.getUserOrAdminBySessionId(token);

        if (obj != null) {
            // 更新过期时间
            redisService.updateExpireTime(token);

            if (obj instanceof tech.linjuliwhu.domain.User) {

                tech.linjuliwhu.domain.User user = (tech.linjuliwhu.domain.User) obj;

                if (id.equals(user.getUserId())) {

                    if (user.getUserType().equals(MyConstants.USER_TYPE_OPERATION_ADMIN)
                            || user.getUserType().equals(MyConstants.USER_TYPE_DEV_ADMIN)) {
                        return User.builder()
                                .username(id)
                                .password("")
                                .authorities(Role.ADMIN, Role.USER)
                                .build();
                    } else {
                        return User.builder()
                                .username(id)
                                .password("")
                                .authorities(Role.USER)
                                .build();
                    }
                }
            }
        }

        return User.builder()
                .username(id)
                .password("")
                .authorities(Role.VISITOR).build();
    }
}
