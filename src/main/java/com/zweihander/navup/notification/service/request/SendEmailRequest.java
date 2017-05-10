package com.zweihander.navup.notification.service.request;

import com.zweihander.navup.notification.Request;
import com.zweihander.navup.notification.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by Nsovo on 2017/03/28.
 */
@AllArgsConstructor
@Getter
@Setter
public class SendEmailRequest extends Request{

    private static final long serialVersionUID = 3217162401112396608L;

    private User user;

    private String subject;

    private String message;

    private boolean isMultipart;

    private boolean isHtml;
}
