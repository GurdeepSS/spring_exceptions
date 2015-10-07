package com.spring.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exceptions.UserNotFoundException;
import com.spring.models.User;

/**
 * Users Rest Controller
 * Users controller is an example of handling exceptions by just throwing them
 * The response status code and message are set in the exception class itself @see com.spring.exceptions.UserNotFoundException
 * @author ahmad.bakr
 *
 */
@RestController
@RequestMapping("/users")
public class UserController {

    private User user;

    public UserController() {
        user = new User();
        user.setId(1);
        user.setName("spring user");
        user.setEmail("user@spring.com");
    }

    /**
     * Get user by id
     * This is an example of handling error per exception. Just throwing UserNotFoundException with
     * 404 and a reason that were defined in the Exception itself. @see com.spring.exceptions.UserNotFoundException
     * Here you have neither an exception handler nor a exception response formatter
     * @param id id
     * @return user if the id matches user's id otherwise throw an exception
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User get(@PathVariable(value = "id") int id) {
        if (id == user.getId()) {
            return user;
        }
        throw new UserNotFoundException();
    }

}
