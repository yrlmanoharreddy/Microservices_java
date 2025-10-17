package com.manuBank.loan.entity;

import jakarta.persistence.Column;

import java.util.Date;

public class BaseEntity {

    @Column(updatable = false)
    private Date createdAt;
    @Column(updatable = false)
    private String createdBy;
    @Column(insertable = false)
    private Date updateAt;
    @Column(insertable=false)
    private String updatedBy;

    public BaseEntity() {
    }

    public BaseEntity(Date createdAt, String createdBy, Date updateAt, String updatedBy) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
        this.updateAt = updateAt;
        this.updatedBy = updatedBy;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }


    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdAt=" + createdAt +
                ", createdBy='" + createdBy + '\'' +
                ", updateAt=" + updateAt +
                ", updatedBy='" + updatedBy + '\'' +
                '}';
    }
}
