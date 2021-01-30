package br.com.rfasioli.redispoc.interfaces.subscribers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

@Component
public class RedisMessageSubscriber implements MessageListener {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisMessageSubscriber.class.getName());

    public void onMessage(Message message, byte[] pattern) {
        LOGGER.info("Message received: " + message.toString());
    }
}