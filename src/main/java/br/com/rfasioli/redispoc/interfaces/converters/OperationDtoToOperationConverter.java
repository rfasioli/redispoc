package br.com.rfasioli.redispoc.interfaces.converters;

import br.com.rfasioli.redispoc.domains.Operation;
import br.com.rfasioli.redispoc.interfaces.dtos.OperationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OperationDtoToOperationConverter implements Converter<OperationDto, Operation> {
    private final ItemDtoToItemConverter itemDtoToItemConverter;

    public OperationDtoToOperationConverter(ItemDtoToItemConverter itemDtoToItemConverter) {
        this.itemDtoToItemConverter = itemDtoToItemConverter;
    }

    @Override
    public Operation convert(OperationDto source) {
        return Operation.newBuilder()
                .withId(source.getId())
                .withDescription(source.getDescription())
                .withCreatedAt(source.getCreatedAt())
                .withItens(source.getItens().stream().map(
                        i -> itemDtoToItemConverter.convert(i)).collect(Collectors.toList()))
                .build();
    }
}
