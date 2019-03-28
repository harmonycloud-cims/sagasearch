package com.harmonycloud.sagaquery.repository;

import com.harmonycloud.sagaquery.entity.TxeventEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TxEventRepository extends JpaRepository<TxeventEntity,Long> {

}
