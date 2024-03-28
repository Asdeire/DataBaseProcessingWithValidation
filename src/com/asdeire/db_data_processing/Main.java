package com.asdeire.db_data_processing;

import com.asdeire.db_data_processing.service.builders.ValidationBuilder;
import com.asdeire.db_data_processing.service.chains.ValidatorChain;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String email = "invalid.email";
        String username = "in";

        ValidatorChain emailValidatorChain = new ValidationBuilder()
                .addEmailValidator()
                .build();

        ValidatorChain usernameValidatorChain = new ValidationBuilder()
                .addUsernameValidator()
                .build();

        List<String> emailErrors = emailValidatorChain.validate(email);
        if (emailErrors.isEmpty()) {
            System.out.println("Input is valid");
        } else {
            System.out.println("Input is invalid. Errors:");
            for (String error : emailErrors) {
                System.out.println("- " + error);
            }
        }

        List<String> usernameErrors = usernameValidatorChain.validate(username);
        if (usernameErrors.isEmpty()) {
            System.out.println("Input is valid");
        } else {
            System.out.println("Input is invalid. Errors:");
            for (String error : usernameErrors) {
                System.out.println("- " + error);
            }
        }
    }
}
