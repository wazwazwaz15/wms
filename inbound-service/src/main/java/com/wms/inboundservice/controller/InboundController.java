package com.wms.inboundservice.controller;

import com.wms.inboundservice.contant.InboundStatus;
import com.wms.inboundservice.dto.InboundRecordDto;
import com.wms.inboundservice.model.InboundRecord;
import com.wms.inboundservice.service.InboundService;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "Inbound 模組", description = "入庫相關操作")
@RequestMapping("/api/inbound")
public class InboundController {
    @Autowired
    private InboundService inboundService;

    @PostMapping("/create")
    @Operation(summary = "建立入庫紀錄",
            description = "新增一筆入庫資料",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    description = "要建立的入庫資料",
                    required = true,
                    content = {@Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    implementation = InboundRecordDto.class
                            )
                    )}
            )
    )
    @ApiResponses({
            @ApiResponse(responseCode = "201", description = "成功建立"),
            @ApiResponse(responseCode = "400", description = "參數輸入失敗")
    })
    public ResponseEntity<InboundRecord> create(@RequestBody @Valid InboundRecordDto dto) {
        InboundRecord record = inboundService.createInboundRecord(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(record);
    }


    @GetMapping("/read/{recordId}")
    @Operation(summary = "找尋一筆特定入庫資料", description = "")
    @Parameter(name = "recordId", required = true, description = "紀錄ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200",
                    description = "成功搜尋",
                    content = @Content(mediaType = "application/json", schema = @Schema(implementation = InboundRecord.class))
            ),
            @ApiResponse(responseCode = "404"
                    , description = "找尋不到資料"
                    , content = @Content())
    })
    public ResponseEntity<InboundRecord> read(@PathVariable Long recordId) {
        InboundRecord record = inboundService.getInboundRecordById(recordId);
        return ResponseEntity.status(HttpStatus.OK).body(record);

    }

    @GetMapping("/readAll")
    @Operation(summary = "找尋全部入庫資料")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功搜尋"),
            @ApiResponse(responseCode = "404", description = "找尋不到資料")
    })
    public ResponseEntity<List<InboundRecord>> readAll() {
        List<InboundRecord> record = inboundService.getAllInboundRecords();
        return ResponseEntity.status(HttpStatus.OK).body(record);
    }


    @GetMapping("/update/{recordId}")
    @Parameter(name = "recordId", required = true, description = "紀錄ID")
    @Operation(summary = "更新入庫狀態")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "成功更新狀態"),
            @ApiResponse(responseCode = "404", description = "找尋不到資料")
    }
    )
    public ResponseEntity<InboundRecord> updateStatus(@PathVariable Long recordId, @RequestParam(required = true) InboundStatus inboundStatus) {
        InboundRecord record = inboundService.updateInboundStatus(recordId, inboundStatus);
        return ResponseEntity.status(HttpStatus.OK).body(record);
    }


}
