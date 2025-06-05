package com.wms.inboundservice.service;

import com.wms.inboundservice.contant.InboundStatus;
import com.wms.inboundservice.dto.InboundRecordDto;
import com.wms.inboundservice.dto.InboundRecordQuery;
import com.wms.inboundservice.model.InboundRecord;

import java.util.List;

public interface InboundService {
    //建立入庫紀錄
    InboundRecord createInboundRecord(InboundRecordDto dto);

    //根據 ID 查詢單一入庫紀錄
    InboundRecord getInboundRecordById(Long recordId);

    //查詢所有入庫紀錄
    List<InboundRecord> getAllInboundRecords();

    // 更新入庫狀態（例如：RECEIVED → INSPECTED）
    InboundRecord updateInboundStatus(Long recordId, InboundStatus newStatus);


    // 根據條件查詢（可傳入 productCode、status、supplier 等查詢參數）
    List<InboundRecord> searchInboundRecords(InboundRecordQuery query);

    // 刪除某筆入庫紀錄
    void deleteInboundRecord(Long recordId);



}
