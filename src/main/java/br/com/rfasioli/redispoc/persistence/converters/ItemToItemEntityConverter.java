package br.com.rfasioli.redispoc.persistence.converters;

import br.com.rfasioli.redispoc.domains.Item;
import br.com.rfasioli.redispoc.persistence.entities.ItemEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ItemToItemEntityConverter implements Converter<Item, ItemEntity> {
    @Override
    public ItemEntity convert(Item source) {
        return ItemEntity.of(source.getId(), source.getDescription(), source.getCreatedAt());
    }
}
