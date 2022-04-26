package br.dev.diego.superpedidos.services.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = ClienteUpdateValidator.class)
@Target({ TYPE })
@Retention(RUNTIME)
public @interface ClienteUpdate {

    String message() default "Erro de validação";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}