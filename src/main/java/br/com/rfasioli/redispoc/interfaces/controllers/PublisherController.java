package br.com.rfasioli.redispoc.interfaces.controllers;

import br.com.rfasioli.redispoc.interfaces.converters.ItemDtoToItemConverter;
import br.com.rfasioli.redispoc.interfaces.dtos.ItemDto;
import br.com.rfasioli.redispoc.services.JedisPublisherService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/publisher")
public class PublisherController {

    private final JedisPublisherService jedisPublisherService;
    private final ItemDtoToItemConverter itemDtoToItemConverter;

    public PublisherController(JedisPublisherService jedisPublisherService,
                               ItemDtoToItemConverter itemDtoToItemConverter) {
        this.jedisPublisherService = jedisPublisherService;
        this.itemDtoToItemConverter = itemDtoToItemConverter;
    }

    @PostMapping
    public void sendMessage(@RequestParam String message) {
        jedisPublisherService.send(message);
    }

    @PostMapping("/item")
    public void sendItem(@RequestBody ItemDto item) throws JsonProcessingException {
        jedisPublisherService.send(
                itemDtoToItemConverter.convert(item));
    }
}
