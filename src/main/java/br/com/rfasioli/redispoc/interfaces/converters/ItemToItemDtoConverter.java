package br.com.rfasioli.redispoc.interfaces.converters;

import br.com.rfasioli.redispoc.domains.Item;
import br.com.rfasioli.redispoc.interfaces.dtos.ItemDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemDtoConverter implements Converter<Item, ItemDto> {
    @Override
    public ItemDto convert(Item source) {
        return ItemDto.of(
                source.getId(),
                source.getDescription(),
                source.getCreatedAt(),
                source.getPriority());
    }
}
