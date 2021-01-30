package br.com.rfasioli.redispoc.services;

import br.com.rfasioli.redispoc.domains.Item;
import br.com.rfasioli.redispoc.interfaces.publishers.MessagePublisher;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

@Service
public class JedisPublisherService {
    private final ObjectMapper objectMapper;
    private final MessagePublisher messagePublisher;

    public JedisPublisherService(ObjectMapper objectMapper,
                                 MessagePublisher messagePublisher) {
        this.objectMapper = objectMapper;
        this.messagePublisher = messagePublisher;
    }

    public void send(String message) {
        this.messagePublisher.publish(message);
    }

    public void send(Item item) throws JsonProcessingException {
        String serializedItem = this.objectMapper.writeValueAsString(item);
        this.messagePublisher.publish(serializedItem);
    }

}
