package com.wms.inboundservice.dto;

import com.wms.inboundservice.contant.InboundStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.sql.Timestamp;

public class InboundRecordQuery {

    @NotBlank
    private String productCode;
    @NotNull
    private InboundStatus inboundStatus;
    @NotBlank
    private String supplier;
    private Timestamp startDate;
    private Timestamp endDate;
}
