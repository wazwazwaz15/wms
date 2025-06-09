package com.wms.inboundservice.util;

import com.wms.inboundservice.dto.InboundRecordQuery;
import com.wms.inboundservice.model.InboundRecord;

import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


public class InboundRecordSpecification {

    public static Specification<InboundRecord> build(InboundRecordQuery query) {
        return ((root, query1, criteriaBuilder) -> {
            List<Predicate> predicateList = new ArrayList<>();

               if(query.getProductCode()!=null){
                   predicateList.add(criteriaBuilder.equal(root.get("productCode"),query.getProductCode()));
               }
               if(query.getInboundStatus() !=null){
                   predicateList.add(criteriaBuilder.equal(root.get("inboundStatus"),query.getInboundStatus()));
               }

               if(query.getSupplier()!=null){
                   predicateList.add(criteriaBuilder.equal(root.get("supplier"),query.getSupplier()));
               }
              if(query.getStartDate()!=null){
                  predicateList.add(criteriaBuilder.greaterThanOrEqualTo(root.get("receivedAt"),query.getStartDate()));
              }
              if(query.getEndDate()!=null){
                  predicateList.add(criteriaBuilder.lessThanOrEqualTo(root.get("receivedAt"),query.getEndDate()));
              }
            return criteriaBuilder.and(predicateList.toArray(new Predicate[0]));
        });

    }
}
