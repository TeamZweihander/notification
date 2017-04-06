package com.zweihander.navup.notification.request;

import com.zweihander.navup.notification.Request;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Nsovo on 2017/03/28.
 */
@AllArgsConstructor
@Getter
public class SendEmailRequest extends Request{

    private static final long serialVersionUID = 3217162401112396608L;

    private String to;

    private String subject;

    private String message;

    private boolean isMultipart;

    private boolean isHtml;
}
