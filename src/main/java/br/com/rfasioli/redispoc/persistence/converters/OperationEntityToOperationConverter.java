package br.com.rfasioli.redispoc.persistence.converters;

import br.com.rfasioli.redispoc.domains.Operation;
import br.com.rfasioli.redispoc.persistence.entities.OperationEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OperationEntityToOperationConverter implements Converter<OperationEntity, Operation> {
    private final ItemEntityToItemConverter itemToItemEntityConverter;

    public OperationEntityToOperationConverter(ItemEntityToItemConverter itemToItemEntityConverter) {
        this.itemToItemEntityConverter = itemToItemEntityConverter;
    }

    @Override
    public Operation convert(OperationEntity source) {
        return Operation.newBuilder()
                .withId(source.getId())
                .withDescription(source.getDescription())
                .withCreatedAt(source.getCreatedAt())
                .withItens(source.getItens().stream().map(
                        i -> itemToItemEntityConverter.convert(i)).collect(Collectors.toList()))
                .build();
    }
}
