package com.wms.inboundservice.dto;

import com.wms.inboundservice.contant.InboundStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class InboundRecordQuery {


    private String productCode;

    private InboundStatus inboundStatus;

    private String supplier;
    private Timestamp startDate;
    private Timestamp endDate;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public InboundStatus getInboundStatus() {
        return inboundStatus;
    }

    public void setInboundStatus(InboundStatus inboundStatus) {
        this.inboundStatus = inboundStatus;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }
}
