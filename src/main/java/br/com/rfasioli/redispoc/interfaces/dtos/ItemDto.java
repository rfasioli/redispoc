package br.com.rfasioli.redispoc.interfaces.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.UUID;

public class ItemDto {
    @JsonProperty(required = false)
    private UUID id;

    @JsonProperty(required = true)
    private String description;

    @JsonProperty(value = "created_at", required = false)
    private LocalDateTime createdAt;

    @JsonProperty(required = false)
    private Long priority;

    public ItemDto() {
    }

    public ItemDto(UUID id, String description, LocalDateTime createdAt, Long priority) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.priority = priority;
    }

    public static ItemDto of(UUID id, String description, LocalDateTime createdAt, Long priority) {
        return new ItemDto(id, description, createdAt, priority);
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

    public Long getPriority() {
        return priority;
    }

    public void setPriority(Long priority) {
        this.priority = priority;
    }
}
