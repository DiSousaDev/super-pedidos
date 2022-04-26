package br.dev.diego.superpedidos.services.validation;

import br.dev.diego.superpedidos.controllers.exceptions.CustomFieldError;
import br.dev.diego.superpedidos.entities.Cliente;
import br.dev.diego.superpedidos.entities.dto.ClienteUpdateDto;
import br.dev.diego.superpedidos.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteUpdateDto> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private HttpServletRequest request;

    @Override
    public void initialize(ClienteUpdate ann) {
    }

    @Override
    public boolean isValid(ClienteUpdateDto objDto, ConstraintValidatorContext context) {

        Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<CustomFieldError> list = new ArrayList<>();

        Optional<Cliente> obj = clienteRepository.findByEmail(objDto.getEmail());

        if(obj.isPresent() && !obj.get().getId().equals(uriId)) {
            list.add(new CustomFieldError("email", "E-mail já cadastrado."));
        }

        for (CustomFieldError e : list) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getFieldMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return list.isEmpty();
    }
}
