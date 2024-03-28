package com.asdeire.db_data_processing.service;

import com.asdeire.db_data_processing.service.impl.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UsernameValidator implements Validator {

    private static final String USERNAME_PATTERN = "^[a-zA-Z0-9_-]{3,16}$";
    private final Pattern pattern;

    public UsernameValidator() {
        this.pattern = Pattern.compile(USERNAME_PATTERN);
    }

    @Override
    public List<String> validate(String value) {
        List<String> errors = new ArrayList<>();
        if (value == null || value.isEmpty()) {
            errors.add("Username не може бути порожнім");
        } else {
            Matcher matcher = pattern.matcher(value);
            if (!matcher.matches()) {
                errors.add("Недопустимий формат username. Допустимі символи: латинські букви, цифри, '_', '-'");
                errors.add("Довжина username повинна бути від 3 до 16 символів");
            }
        }
        return errors;
    }
}
