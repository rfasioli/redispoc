package br.com.rfasioli.redispoc.persistence.entities;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@RedisHash("Item")
public class ItemEntity implements Serializable {
    private UUID id;
    private String description;
    private LocalDateTime createdAt;

    public ItemEntity() {
    }

    private ItemEntity(UUID id, String description, LocalDateTime createdAt) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
    }

    public static ItemEntity of(UUID id, String description, LocalDateTime createdAt) {
        return new ItemEntity(id, description, createdAt);
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
