package br.com.rfasioli.redispoc.domains;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Operation {
    private UUID id;
    private String description;
    private LocalDateTime createdAt;
    private List<Item> itens = new ArrayList<>();

    public Operation() {
    }

    private Operation(Builder builder) {
        id = builder.id;
        description = builder.description;
        createdAt = builder.createdAt;
        itens = builder.itens;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Operation copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.description = copy.getDescription();
        builder.createdAt = copy.getCreatedAt();
        builder.itens = copy.getItens();
        return builder;
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public List<Item> getItens() {
        return itens;
    }

    public static final class Builder {
        private UUID id;
        private String description;
        private LocalDateTime createdAt;
        private List<Item> itens;

        private Builder() {
        }

        public Builder withId(UUID val) {
            id = val;
            return this;
        }

        public Builder withDescription(String val) {
            description = val;
            return this;
        }

        public Builder withCreatedAt(LocalDateTime val) {
            createdAt = val;
            return this;
        }

        public Builder withItens(List<Item> val) {
            itens = val;
            return this;
        }

        public Operation build() {
            return new Operation(this);
        }
    }
}
