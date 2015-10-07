package com.spring.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * UserNotFound Exception
 * @author ahmad.bakr
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "user can not be found!")
public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

}
