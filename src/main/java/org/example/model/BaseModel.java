package org.example.model;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class BaseModel {
    protected boolean isDeleted;
    protected LocalDateTime createdAt;
    protected LocalDateTime deletedAt;

    protected BaseModel(){
        this.createdAt = LocalDateTime.now();
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(LocalDateTime deletedAt) {
        this.deletedAt = deletedAt;
    }

}
