package com.example.spring_mvc.validator;

import com.example.spring_mvc.pojo.User;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if (target == null) {
            errors.rejectValue("", null, "User name can't be null.");
            return;
        }
        User user = (User) target;
        if(StringUtils.isEmpty(user.getUserName())) {
            errors.rejectValue("userName", null, "User can't be null.");
        }
    }
}
