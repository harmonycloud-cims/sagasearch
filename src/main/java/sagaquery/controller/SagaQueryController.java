package sagaquery.controller;

import com.alibaba.fastjson.JSON;
import sagaquery.bo.CommandBo;
import sagaquery.entity.Command;
import sagaquery.repository.CommandRepository;
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
    CommandRepository commandRepository;

    @GetMapping("/search")
    @ApiOperation(value = "search saga db", response = CommandBo.class)
    @ApiImplicitParam(name = "gloablid", value = "gloablid", paramType = "query", dataType = "String")
    public List<CommandBo> getPayload(@RequestParam("gloablid") String globalid) {

        Command command = new Command();
        command.setGlobaltxid(globalid);
        Example<Command> example = Example.of(command);
        List<Command> results = commandRepository.findAll(example);
        List<CommandBo> commandBoList = new ArrayList<>();

        results.stream().forEach(item -> {
            CommandBo commandBo = new CommandBo();
            Object[] argss = {};
            KryoMessageFormat format = new KryoMessageFormat();
            if (item.getStatus().equals("PENDING")) {
                try {
                    byte[] payload = item.getPayloads();
                    if (payload != null && payload.length > 0) {
                        argss = format.deserialize(payload);
                    }
                    BeanUtils.copyProperties(item, commandBo, "payloads");
                    commandBo.setPayloads(JSON.toJSONString(argss));

                } catch (Exception e) {
                    if (e instanceof IndexOutOfBoundsException) {
                        BeanUtils.copyProperties(item, commandBo, "payloads");
                        commandBo.setPayloads(new String(item.getPayloads()));
                    } else {
                        throw e;
                    }
                }
                commandBoList.add(commandBo);
            }
        });
        return commandBoList;
    }

}