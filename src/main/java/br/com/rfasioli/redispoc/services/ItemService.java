package br.com.rfasioli.redispoc.services;

import br.com.rfasioli.redispoc.domains.Item;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Tuple;

@Service
public class ItemService {
    private static final String key = "poc:itens";

    private final Jedis jedis;
    private final ObjectMapper objectMapper;

    public ItemService(Jedis jedis, ObjectMapper objectMapper) {
        this.jedis = jedis;
        this.objectMapper = objectMapper;
    }

    public void save(Item item) throws JsonProcessingException {
        String serializedItem = objectMapper.writeValueAsString(item);
        jedis.zadd(key,
                item.getPriority(),
                serializedItem);
    }

    public Item pop() throws JsonProcessingException {
        Tuple tuple = jedis.zpopmin(key);
        return objectMapper.readValue(tuple.getElement(), Item.class);
    }
}
