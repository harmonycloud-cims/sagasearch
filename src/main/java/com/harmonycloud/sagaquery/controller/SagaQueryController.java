package com.harmonycloud.sagaquery.controller;

import com.alibaba.fastjson.JSON;
import com.harmonycloud.sagaquery.entity.TxeventEntity;
import com.harmonycloud.sagaquery.repository.TxEventRepository;
import org.apache.servicecomb.saga.omega.format.KryoMessageFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SagaQueryController {

    @Autowired
    TxEventRepository eventRepository;

    @GetMapping("/test")
    public String getPayload(@RequestParam("gloablid") String globalid){
        TxeventEntity entity=new TxeventEntity();
        entity.setGlobaltxid(globalid);
        Example<TxeventEntity> example=Example.of(entity);
        List<TxeventEntity> results=eventRepository.findAll(example);
        results.stream().forEach(item->{
            System.out.println(item.getInstanceid());
            byte[] payload=item.getPayloads();
            KryoMessageFormat format=new KryoMessageFormat();
            Object[] argss=format.deserialize(payload);
            System.out.println(JSON.toJSONString(argss));

        });

        return "test";

    }


}