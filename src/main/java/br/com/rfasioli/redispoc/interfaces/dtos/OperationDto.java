package br.com.rfasioli.redispoc.interfaces.dtos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OperationDto {
    private UUID id;
    private String description;
    private LocalDateTime createdAt;
    private List<ItemDto> itens;

    public OperationDto() {
    }

    private OperationDto(UUID id, String description, LocalDateTime createdAt, List<ItemDto> itens) {
        this.id = id;
        this.description = description;
        this.createdAt = createdAt;
        this.itens = itens;
    }

    public static OperationDto of(UUID id, String description, LocalDateTime createdAt, List<ItemDto> itens) {
        return new OperationDto(id, description, createdAt, itens);
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

    public List<ItemDto> getItens() {
        return itens;
    }

    public void setItens(List<ItemDto> itens) {
        this.itens = itens;
    }
}
