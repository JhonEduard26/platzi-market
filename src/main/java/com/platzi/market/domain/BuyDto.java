package com.platzi.market.domain;

import java.time.LocalDateTime;
import java.util.List;

public class BuyDto {

    private long buyId;
    private String clientId;
    private LocalDateTime date;
    private String paymentMethod;
    private String comment;
    private String status;
    private List<BuyProductDto> items;

    public long getBuyId() {
        return buyId;
    }

    public void setBuyId(long buyId) {
        this.buyId = buyId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BuyProductDto> getItems() {
        return items;
    }

    public void setItems(List<BuyProductDto> items) {
        this.items = items;
    }
}
