package com.wms.inboundservice.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Schema(description = "創建資料表")
public class InboundRecordDto {
    @Schema(description = "商品代碼", example = "116610LV")
    @NotBlank
    private String productCode;
    @Schema(description = "商品名稱", example = "ROLEX")
    @NotBlank
    private String productName;
    @Schema(description = "數量",example = "50")
    @NotNull
    private Integer quantity;
    @Schema(description = "供應商",example = "COSTCO")
    @NotBlank
    private String supplier;
    @NotBlank
    private String locationCode;
    @NotBlank
    private String createdBy;
    @NotBlank
    private String remark;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getLocationCode() {
        return locationCode;
    }

    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
