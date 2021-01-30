package br.com.rfasioli.redispoc.persistence.dataservices;

import br.com.rfasioli.redispoc.domains.Operation;
import br.com.rfasioli.redispoc.exceptions.DataNotFoundException;
import br.com.rfasioli.redispoc.persistence.converters.OperationEntityToOperationConverter;
import br.com.rfasioli.redispoc.persistence.converters.OperationToOperationEntityConverter;
import br.com.rfasioli.redispoc.persistence.repositories.OperationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OperationDAOService {
    public static final String key = "poc:operation";

    private final OperationToOperationEntityConverter operationToOperationEntityConverter;
    private final OperationEntityToOperationConverter operationEntityToOperationConverter;
    private final OperationRepository operationRepository;

    public OperationDAOService(OperationToOperationEntityConverter operationToOperationEntityConverter,
                               OperationEntityToOperationConverter operationEntityToOperationConverter,
                               OperationRepository operationRepository) {
        this.operationToOperationEntityConverter = operationToOperationEntityConverter;
        this.operationEntityToOperationConverter = operationEntityToOperationConverter;
        this.operationRepository = operationRepository;
    }

    public void save(Operation operation) {
        operationRepository.save(
                operationToOperationEntityConverter.convert(operation));
    }

    public void delete(UUID id) {
        operationRepository.deleteById(id);
    }

    public Operation get(UUID id) {
        return operationEntityToOperationConverter.convert(
                operationRepository.findById(id).orElseThrow(
                        () -> new DataNotFoundException("Operation not found for id {%s}".format(id.toString()))));
    }

    public List<Operation> listAll() {
        return StreamSupport.stream(
                operationRepository.findAll().spliterator(), false)
                .map(o -> operationEntityToOperationConverter.convert(o))
                .collect(Collectors.toList());
    }
}
