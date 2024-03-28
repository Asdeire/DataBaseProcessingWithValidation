package com.asdeire.db_data_processing.service.chains;

import com.asdeire.db_data_processing.service.impl.Validator;

import java.util.ArrayList;
import java.util.List;

public class ValidatorChain {
    private List<Validator> validators;

    public ValidatorChain() {
        validators = new ArrayList<>();
    }

    public void addValidator(Validator validator) {
        validators.add(validator);
    }

    public List<String> validate(String input) {
        List<String> errors = new ArrayList<>();
        for (Validator validator : validators) {
            errors.addAll(validator.validate(input));
        }
        return errors;
    }
}
