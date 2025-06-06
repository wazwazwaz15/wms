package com.wms.inboundservice.dao;

import com.wms.inboundservice.model.InboundRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InboundDao extends JpaRepository<InboundRecord, Long> {

    InboundRecord getInboundRecordByRecordId(Long recordId);

    List<InboundRecord> findAll();

}
