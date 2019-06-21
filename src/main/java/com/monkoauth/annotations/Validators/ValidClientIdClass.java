package com.monkoauth.annotations.Validators;

import com.monkoauth.annotations.ValidClientId;
import com.monkoauth.utils.Constants;
import org.springframework.web.bind.annotation.ControllerAdvice;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolationException;
import java.io.IOException;

public class ValidClientIdClass implements ConstraintValidator<ValidClientId, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return Constants.SOCIAL_CLIENTS.clientIds.contains(value);
    }
}
