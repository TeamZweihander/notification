package com.zweihander.navup.notification.service.Utilities;

import com.zweihander.navup.notification.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by George on 2017-05-09.
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {


        final private String userService = "http://localhost:8080/springrestexample/employees.xml";

        private RestTemplate restTemplate;

        public User findUserByUserid(long userid) {


            return restTemplate.getForObject(userService+"/user/userid", User.class);


       }

         public User findByResetToken(String resetToken)
         {
             RestTemplate restTemplate = new RestTemplate();
             return restTemplate.getForObject(userService+"/user/resetToken", User.class);


        }

           public void save(User user) {
                //   user.save;
           }

}
