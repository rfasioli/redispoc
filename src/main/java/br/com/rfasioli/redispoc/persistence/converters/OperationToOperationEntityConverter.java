package br.com.rfasioli.redispoc.persistence.converters;

import br.com.rfasioli.redispoc.domains.Operation;
import br.com.rfasioli.redispoc.persistence.entities.OperationEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OperationToOperationEntityConverter implements Converter<Operation, OperationEntity> {
    private final ItemToItemEntityConverter itemToItemEntityConverter;

    public OperationToOperationEntityConverter(ItemToItemEntityConverter itemToItemEntityConverter) {
        this.itemToItemEntityConverter = itemToItemEntityConverter;
    }

    @Override
    public OperationEntity convert(Operation source) {
        return OperationEntity.of(
                source.getId(),
                source.getDescription(),
                source.getCreatedAt(),
                source.getItens().stream().map(
                        i -> itemToItemEntityConverter.convert(i)).collect(Collectors.toList()));
    }
}
