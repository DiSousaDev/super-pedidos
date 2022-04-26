package br.dev.diego.superpedidos.services.validation;

import br.dev.diego.superpedidos.controllers.exceptions.CustomFieldError;
import br.dev.diego.superpedidos.entities.dto.ClienteInsertDto;
import br.dev.diego.superpedidos.entities.enums.TipoCliente;
import br.dev.diego.superpedidos.services.validation.utils.BR;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteInsertDto> {

    @Override
    public void initialize(ClienteInsert ann) {
    }

    @Override
    public boolean isValid(ClienteInsertDto objDto, ConstraintValidatorContext context) {

        List<CustomFieldError> list = new ArrayList<>();

        if (objDto.getTipo().equals(TipoCliente.PESSOA_FISICA.getCod()) && !BR.isValidCPF(objDto.getCpfOuCnpj())) {
            list.add(new CustomFieldError("cpfOuCnpj", "CPF inválido"));
        }

        if (objDto.getTipo().equals(TipoCliente.PESSOA_JURIDICA.getCod()) && !BR.isValidCNPJ(objDto.getCpfOuCnpj())) {
            list.add(new CustomFieldError("cpfOuCnpj", "CNPJ inválido"));
        }

        for (CustomFieldError e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
