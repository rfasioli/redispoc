package br.com.rfasioli.redispoc.persistence.entities;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RedisHash("Operation")
public class OperationEntity implements Serializable {
    private UUID id;
    private String description;
    private LocalDateTime createdAt;
    private List<ItemEntity> itens = new ArrayList<>();

    public OperationEntity() {
    }

    private OperationEntity(UUID id, String description, LocalDateTime createdAt, List<ItemEntity> itens) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.itens = itens;
    }

    public static OperationEntity of(UUID id, String description, LocalDateTime createdAt, List<ItemEntity> itens) {
        return new OperationEntity(id, description, createdAt, itens);
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

    public List<ItemEntity> getItens() {
        return itens;
    }

    public void setItens(List<ItemEntity> itens) {
        this.itens = itens;
    }
}
