package sagaquery.controller;

import com.alibaba.fastjson.JSON;
import sagaquery.bo.TxeventBo;
import sagaquery.entity.TxeventEntity;
import sagaquery.repository.TxEventRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
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
@Api(value = "SagaSearch")
public class SagaQueryController {

    @Autowired
    TxEventRepository eventRepository;

    @GetMapping("/search")
    @ApiOperation(value = "search saga db", response = TxeventBo.class)
    @ApiImplicitParam(name = "gloablid", value = "gloablid", paramType = "query", dataType = "String")
    public List<TxeventBo> getPayload(@RequestParam("gloablid") String globalid) {

        TxeventEntity entity = new TxeventEntity();
        entity.setGlobaltxid(globalid);
        Example<TxeventEntity> example = Example.of(entity);
        List<TxeventEntity> results = eventRepository.findAll(example);
        List<TxeventBo> txeventBoList = new ArrayList<>();

        results.stream().forEach(item -> {
            TxeventBo txeventBo = new TxeventBo();
            Object[] argss = {};
            KryoMessageFormat format = new KryoMessageFormat();
            try {
                byte[] payload = item.getPayloads();
                if(payload != null && payload.length > 0) {
                    argss = format.deserialize(payload);
                }
                BeanUtils.copyProperties(item, txeventBo, "payloads");
                txeventBo.setPayloads(JSON.toJSONString(argss));

            } catch (Exception e) {
                if (e instanceof IndexOutOfBoundsException) {
                    BeanUtils.copyProperties(item, txeventBo, "payloads");
                    txeventBo.setPayloads(new String(item.getPayloads()));
                } else {
                    throw e;
                }
            }
            txeventBoList.add(txeventBo);
        });


        return txeventBoList;
    }

}