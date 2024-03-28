package com.asdeire.db_data_processing.service.builders;

import com.asdeire.db_data_processing.service.EmailValidator;
import com.asdeire.db_data_processing.service.UsernameValidator;
import com.asdeire.db_data_processing.service.chains.ValidatorChain;

public class ValidationBuilder {
    private ValidatorChain chain;

    public ValidationBuilder() {
        chain = new ValidatorChain();
    }

    public ValidationBuilder addEmailValidator() {
        chain.addValidator(new EmailValidator());
        return this;
    }

    public ValidationBuilder addUsernameValidator(){
        chain.addValidator(new UsernameValidator());
        return this;
    }

    public ValidatorChain build() {
        return chain;
    }
}
