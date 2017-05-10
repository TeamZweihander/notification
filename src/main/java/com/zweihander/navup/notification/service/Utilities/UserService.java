package com.zweihander.navup.notification.service.Utilities;

import com.zweihander.navup.notification.domain.User;

/**
 * Created by George on 2017-05-09.
 */
public interface UserService {

     User findUserByUserid(long userid);
     User findByResetToken(String resetToken);

     void save(User user);
}
