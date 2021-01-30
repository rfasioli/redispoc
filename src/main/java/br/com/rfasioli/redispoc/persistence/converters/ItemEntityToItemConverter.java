package br.com.rfasioli.redispoc.persistence.converters;

import br.com.rfasioli.redispoc.domains.Item;
import br.com.rfasioli.redispoc.persistence.entities.ItemEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemEntityToItemConverter implements Converter<ItemEntity, Item> {
    @Override
    public Item convert(ItemEntity source) {
        return Item.newBuilder()
                .withId(source.getId())
                .withDescription(source.getDescription())
                .withCreatedAt(source.getCreatedAt())
                .build();
    }
}
