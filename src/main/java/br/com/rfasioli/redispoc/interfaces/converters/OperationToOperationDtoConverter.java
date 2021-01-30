package br.com.rfasioli.redispoc.interfaces.converters;

import br.com.rfasioli.redispoc.domains.Operation;
import br.com.rfasioli.redispoc.interfaces.dtos.OperationDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OperationToOperationDtoConverter implements Converter<Operation, OperationDto> {
    private final ItemToItemDtoConverter itemToItemDtoConverter;

    public OperationToOperationDtoConverter(ItemToItemDtoConverter itemToItemDtoConverter) {
        this.itemToItemDtoConverter = itemToItemDtoConverter;
    }

    @Override
    public OperationDto convert(Operation source) {
        return OperationDto.of(
                source.getId(),
                source.getDescription(),
                source.getCreatedAt(),
                source.getItens().stream().map(
                        i -> itemToItemDtoConverter.convert(i)).collect(Collectors.toList()));
    }
}
