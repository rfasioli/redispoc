package br.com.rfasioli.redispoc.interfaces.controllers;

import br.com.rfasioli.redispoc.domains.Item;
import br.com.rfasioli.redispoc.interfaces.dtos.ItemDto;
import br.com.rfasioli.redispoc.services.ItemService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/item")
public class ItemController {
    private final Converter<ItemDto, Item> itemDtoItemConverter;
    private final Converter<Item, ItemDto> itemItemDtoConverter;
    private final ItemService itemService;

    public ItemController(Converter<ItemDto, Item> itemDtoItemConverter,
                          Converter<Item, ItemDto> itemItemDtoConverter,
                          ItemService itemService) {
        this.itemDtoItemConverter = itemDtoItemConverter;
        this.itemItemDtoConverter = itemItemDtoConverter;
        this.itemService = itemService;
    }

    @GetMapping
    public ItemDto popItem() throws JsonProcessingException {
        return itemItemDtoConverter.convert(
                itemService.pop());
    }

    @PostMapping
    public void putItem(@RequestBody ItemDto item) throws JsonProcessingException {
        itemService.save(
                itemDtoItemConverter.convert(item));
    }

}
