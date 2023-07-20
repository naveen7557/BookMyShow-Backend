/*package com.naveen.bookmyshow.validator;

import com.naveen.bookmyshow.pojo.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
@Component
public class PasswordValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;

        if(user.getPassword().length()<6)
        {
            errors.rejectValue("password","Length","Password must be at least 6 characters");

        }
        if(!user.getPassword().equals(user.getConfirmPassword()))
        {
            errors.rejectValue("confirmPassword","Match","Password and Confirm Password must match");
        }

    }
}*/
