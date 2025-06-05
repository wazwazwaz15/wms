package com.wms.inboundservice.controller;

import com.wms.inboundservice.dto.InboundRecordDto;
import com.wms.inboundservice.model.InboundRecord;
import com.wms.inboundservice.service.InboundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Inbound 模組", description = "入庫相關操作")
@RequestMapping("/api/inbound")
public class InboundController {
    @Autowired
    private InboundService inboundService;

    @PostMapping("/create")
    @Operation(summary = "建立入庫紀錄", description = "新增一筆入庫資料")
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "成功建立"),
            @ApiResponse(responseCode = "400", description = "參數輸入失敗")
    })
    public ResponseEntity<InboundRecord> create(@RequestBody @Valid  InboundRecordDto dto) {
        InboundRecord record = inboundService.createInboundRecord(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }


}
