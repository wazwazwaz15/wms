package com.wms.inboundservice.dao;

import com.wms.inboundservice.contant.InboundStatus;
import com.wms.inboundservice.model.InboundRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InboundDao extends JpaRepository<InboundRecord, Long>, JpaSpecificationExecutor<InboundRecord> {

    InboundRecord getInboundRecordByRecordId(Long recordId);

    void deleteByRecordId(Long recordId);






}
