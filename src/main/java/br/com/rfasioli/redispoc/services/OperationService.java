package br.com.rfasioli.redispoc.services;

import br.com.rfasioli.redispoc.domains.Operation;
import br.com.rfasioli.redispoc.persistence.dataservices.OperationDAOService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OperationService {
    public static final String key = "poc:operation";

    private final OperationDAOService operationDAOService;

    public OperationService(OperationDAOService operationDAOService) {
        this.operationDAOService = operationDAOService;
    }

    public void save(Operation operation) {
        operationDAOService.save(operation);
    }

    public void delete(UUID id) {
        operationDAOService.delete(id);
    }

    public Operation get(UUID id) {
        return operationDAOService.get(id);
    }

    public List<Operation> listAll() {
        return StreamSupport.stream(
                operationDAOService.listAll().spliterator(), false).collect(Collectors.toList());
    }
}
