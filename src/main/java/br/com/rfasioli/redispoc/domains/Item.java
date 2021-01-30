package br.com.rfasioli.redispoc.domains;

import java.time.LocalDateTime;
import java.util.UUID;

public class Item {
    private UUID id;
    private String description;
    private LocalDateTime createdAt;
    private Long priority;

    public Item() {
    }

    private Item(Builder builder) {
        id = builder.id;
        description = builder.description;
        createdAt = builder.createdAt;
        priority = builder.priority;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static Builder newBuilder(Item copy) {
        Builder builder = new Builder();
        builder.id = copy.getId();
        builder.description = copy.getDescription();
        builder.createdAt = copy.getCreatedAt();
        builder.priority = copy.getPriority();
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

    public Long getPriority() {
        return priority;
    }

    public static final class Builder {
        private UUID id;
        private String description;
        private LocalDateTime createdAt;
        private Long priority;

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

        public Builder withPriority(Long val) {
            priority = val;
            return this;
        }

        public Item build() {
            return new Item(this);
        }
    }
}
