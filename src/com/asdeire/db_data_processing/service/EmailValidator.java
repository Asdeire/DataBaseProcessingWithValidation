package com.asdeire.db_data_processing.service;
import com.asdeire.db_data_processing.service.impl.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator implements Validator {
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

    @Override
    public List<String> validate(String input) {
        List<String> errors = new ArrayList<>();
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            errors.add("Invalid email format");
        }
        return errors;
    }
}