package com.zweihander.navup.notification;

import com.zweihander.navup.notification.domain.NotificationType;
import com.zweihander.navup.notification.domain.User;
import com.zweihander.navup.notification.exception.NotificationNotSentException;
import com.zweihander.navup.notification.mocks.NotificationMock;
import com.zweihander.navup.notification.request.SendNotificationRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static junit.framework.Assert.assertNotNull;

/**
 * Created by Nsovo on 2017/03/29.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = NavigationTestConfig.class)
public class NavigationMockTest {

    @Inject
    NotificationMock noti;

    @Test(expected = NotificationNotSentException.class)
    public void sendNotificationTest1() throws NotificationNotSentException {
        noti.sendNotification(null);

    }

    @Test
    public void sendNotificationTest2() throws NotificationNotSentException{
        User u = Mockito.mock(User.class);
        assertNotNull("Send Email Test", noti.sendNotification(new SendNotificationRequest(NotificationType.EMAIL, u, "Hello")));

    }

    @Test
    public void sendNotificationTest3() throws NotificationNotSentException{
        User u = Mockito.mock(User.class);
        assertNotNull("Send SMS Test", noti.sendNotification(new SendNotificationRequest(NotificationType.SMS, u, "Hello")));

    }


}
