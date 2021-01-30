package br.com.rfasioli.redispoc.interfaces.converters;

import br.com.rfasioli.redispoc.domains.Item;
import br.com.rfasioli.redispoc.interfaces.dtos.ItemDto;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemDtoToItemConverter implements Converter<ItemDto, Item> {
    @Override
    public Item convert(ItemDto source) {
        return Item.newBuilder()
                .withId(source.getId())
                .withDescription(source.getDescription())
                .withCreatedAt(source.getCreatedAt())
                .withPriority(source.getPriority())
                .build();
    }
}
