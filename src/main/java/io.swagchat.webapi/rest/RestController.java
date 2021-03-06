package io.swagchat.webapi.rest;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import io.swagchat.webapi.model.Service;
import io.swagchat.webapi.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@Api(value = "webapi", description = "web API")
public class RestController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Get analytics", notes = "Returns root")
    public String root() {
        return "";
    }

    @RequestMapping(value = "/api/services/", method = RequestMethod.GET)
    @ApiOperation(value = "Get services", notes = "Returns services")
    public List<Service> getData() {
        return redisService.getListOfServices();
    }


}
