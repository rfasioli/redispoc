package br.com.rfasioli.redispoc.interfaces.controllers;

import br.com.rfasioli.redispoc.interfaces.converters.OperationDtoToOperationConverter;
import br.com.rfasioli.redispoc.interfaces.converters.OperationToOperationDtoConverter;
import br.com.rfasioli.redispoc.interfaces.dtos.OperationDto;
import br.com.rfasioli.redispoc.services.OperationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/operation")
public class OperationController {
    private final OperationToOperationDtoConverter operationToOperationDtoConverter;
    private final OperationDtoToOperationConverter operationDtoToOperationConverter;
    private final OperationService operationService;

    public OperationController(OperationToOperationDtoConverter operationToOperationDtoConverter,
                               OperationDtoToOperationConverter operationDtoToOperationConverter,
                               OperationService operationService) {
        this.operationToOperationDtoConverter = operationToOperationDtoConverter;
        this.operationDtoToOperationConverter = operationDtoToOperationConverter;
        this.operationService = operationService;
    }

    @PostMapping
    public void create(@RequestBody OperationDto operation) throws JsonProcessingException {
        operationService.save(
                operationDtoToOperationConverter.convert(operation));
    }

    @GetMapping("/{uuid}")
    public OperationDto getById(@RequestParam String uuid) {
        return operationToOperationDtoConverter.convert(
                operationService.get(UUID.fromString(uuid)));
    }

    @GetMapping()
    public List<OperationDto> getOperations() {
        return operationService.listAll().stream().map(o ->
                operationToOperationDtoConverter.convert(o)).collect(Collectors.toList());
    }

    @DeleteMapping("/{uuid}")
    public void deleteById(@RequestParam String uuid) {
        operationService.delete(UUID.fromString(uuid));
    }

}
