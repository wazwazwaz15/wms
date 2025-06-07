package com.wms.inboundservice.service.impl;

import com.wms.inboundservice.contant.InboundStatus;
import com.wms.inboundservice.dao.InboundDao;
import com.wms.inboundservice.dto.InboundRecordDto;
import com.wms.inboundservice.dto.InboundRecordQuery;
import com.wms.inboundservice.model.InboundRecord;
import com.wms.inboundservice.service.InboundService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class InboundServiceImpl implements InboundService {
    @Autowired
    private InboundDao inboundDao;


    @Override
    public InboundRecord createInboundRecord(InboundRecordDto dto) {
        InboundRecord record = new InboundRecord();
        record.setProductCode(dto.getProductCode());
        record.setProductName(dto.getProductName());
        record.setInboundStatus(InboundStatus.PENDING);
        record.setQuantity(dto.getQuantity());
        record.setSupplier(dto.getSupplier());
        record.setRemark(dto.getRemark());
        record.setLocationCode(dto.getLocationCode());
        record.setCreatedBy(dto.getCreatedBy());

        record = inboundDao.save(record);
        return record;
    }

    @Override
    public InboundRecord getInboundRecordById(Long recordId) {
        InboundRecord inboundRecord = inboundDao.getInboundRecordByRecordId(recordId);
        if (inboundRecord == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "找不到入庫記錄 ID：" + recordId);
        }

        return inboundRecord;
    }

    @Override
    public List<InboundRecord> getAllInboundRecords() {
        List<InboundRecord> inboundRecordList = inboundDao.findAll();
        if (inboundRecordList.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "目前沒有任何的入庫紀錄");
        }

        return inboundRecordList;
    }

    @Transactional
    @Override
    public InboundRecord updateInboundStatus(Long recordId, InboundStatus newStatus) {

        InboundRecord inboundRecord = inboundDao.findById(recordId).orElseThrow();
        inboundRecord.setInboundStatus(newStatus);
        inboundDao.save(inboundRecord);
        inboundRecord = inboundDao.findById(recordId).orElseThrow();


        return inboundRecord;
    }

    @Override
    public List<InboundRecord> searchInboundRecords(InboundRecordQuery query) {
        return null;
    }

    @Override
    public void deleteInboundRecord(Long recordId) {

    }
}
