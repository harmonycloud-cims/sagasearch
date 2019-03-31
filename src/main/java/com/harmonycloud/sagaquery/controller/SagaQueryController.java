package com.harmonycloud.sagaquery.controller;

import com.alibaba.fastjson.JSON;
import com.harmonycloud.sagaquery.bo.TxeventBo;
import com.harmonycloud.sagaquery.entity.TxeventEntity;
import com.harmonycloud.sagaquery.repository.TxEventRepository;
import org.apache.servicecomb.saga.omega.format.KryoMessageFormat;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SagaQueryController {

    @Autowired
    TxEventRepository eventRepository;

    @GetMapping("/test")
    public List<TxeventBo> getPayload(@RequestParam("gloablid") String globalid) {

        TxeventEntity entity = new TxeventEntity();
        entity.setGlobaltxid(globalid);
        Example<TxeventEntity> example = Example.of(entity);
        List<TxeventEntity> results = eventRepository.findAll(example);
        List<TxeventBo> txeventBoList = new ArrayList<>();
        results.stream().forEach(item -> {
            byte[] payload = item.getPayloads();
            KryoMessageFormat format = new KryoMessageFormat();
            Object[] argss = format.deserialize(payload);
            TxeventBo txeventBo = new TxeventBo();
            BeanUtils.copyProperties(item, txeventBo, "payloads");
            txeventBo.setPayloads(JSON.toJSONString(argss));

            txeventBoList.add(txeventBo);
        });
        return txeventBoList;
    }

}