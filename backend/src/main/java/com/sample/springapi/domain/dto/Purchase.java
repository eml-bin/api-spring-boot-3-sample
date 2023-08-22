package com.sample.springapi.domain.dto;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {
    private int purchaseId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String state;
    private List<PurchaseItem> items;

    public int getPurchaseId() {
        return this.purchaseId;
    }

    public void setPurchaseId(int purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return this.clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return this.date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return this.comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return this.state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public List<PurchaseItem> getItems() {
        return this.items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }


}
