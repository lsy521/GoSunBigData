package com.hzgc.service.device.controller;

import com.hzgc.common.service.BigDataPath;
import com.hzgc.common.service.ResponseResult;
import com.hzgc.service.device.service.WarnRule;
import com.hzgc.service.device.service.WarnRuleServiceImpl;
import com.hzgc.service.device.vo.ConfigRuleVO;
import io.swagger.annotations.*;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@FeignClient(name = "warnRule")
@RequestMapping(value = BigDataPath.WARNRULE,consumes = "application/json",produces = "application/json")
@Api(value = "warnRule",tags = "告警规则")
public class WarnRuleController {

    private static Logger LOG = Logger.getLogger(WarnRuleController.class);

    @Autowired
    WarnRuleServiceImpl warnRuleService;

    @ApiOperation(value = "规则配置",response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 200,message = "successful response")
    })
    @RequestMapping(value = BigDataPath.WARNRULE_CONFIG,method = RequestMethod.POST)
    public ResponseResult<Map<String, Boolean>> configRules(@RequestBody @ApiParam(value = "规则配置参数") ConfigRuleVO configRuleVO) {
        List<String> ipcIDs;
        List<WarnRule> rules;
        if (null != configRuleVO) {
            ipcIDs = configRuleVO.getIpcIDs();
            rules = configRuleVO.getRules();
        } else {
            LOG.info("configRule参数错误");
            return null;
        }
        Map<String, Boolean> map = warnRuleService.configRules(ipcIDs, rules);
        return ResponseResult.init(map);
    }

    @ApiOperation(value = "添加规则",response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 200,message = "successful response")
    })
    @RequestMapping(value = BigDataPath.WARNRULE_ADD,method = RequestMethod.POST)
    public ResponseResult<Map<String, Boolean>> addRules(@RequestBody @ApiParam(value = "规则配置参数") ConfigRuleVO configRuleVO) {
        List<String> ipcIDs;
        List<WarnRule> rules;
        if (null != configRuleVO) {
            ipcIDs = configRuleVO.getIpcIDs();
            rules = configRuleVO.getRules();
        } else {
            return null;
        }
        Map<String, Boolean> map = warnRuleService.addRules(ipcIDs, rules);
        return ResponseResult.init(map);
    }

    @ApiOperation(value = "规则比较",response = List.class)
    @ApiResponses({
            @ApiResponse(code = 200,message = "successful response")
    })
    @RequestMapping(value = BigDataPath.WARNRULE_GETCOMPARE,method = RequestMethod.POST)
    public ResponseResult<List<WarnRule>> getCompareRules(@RequestBody @ApiParam(value = "规则配置参数") ConfigRuleVO configRuleVO) {
        String ipcID;
        if (null != configRuleVO) {
            ipcID = configRuleVO.getIpcID();
        } else {
            return null;
        }
        List<WarnRule> warnRuleList = warnRuleService.getCompareRules(ipcID);
        return ResponseResult.init(warnRuleList);
    }

    @ApiOperation(value = "删除规则",response = Map.class)
    @ApiResponses({
            @ApiResponse(code = 200,message = "successful response")
    })
    @RequestMapping(value = BigDataPath.WARNRULE_DELETE,method = RequestMethod.DELETE)
    public ResponseResult<Map<String, Boolean>> deleteRules(@RequestBody @ApiParam(value = "规则配置参数") ConfigRuleVO configRuleVO) {
        List<String> ipcIdList;
        if (null != configRuleVO) {
            ipcIdList = configRuleVO.getIpcIDs();
        } else {
            return null;
        }
        Map<String, Boolean> map = warnRuleService.deleteRules(ipcIdList);
        return ResponseResult.init(map);
    }

    @ApiOperation(value = "对象类型规则",response = List.class)
    @ApiResponses({
            @ApiResponse(code = 200,message = "successful response")
    })
    @RequestMapping(value = BigDataPath.WARNRULE_OBJECTTYPE_GET,method = RequestMethod.POST)
    public ResponseResult<List<String>> objectTypeHasRule(@RequestBody @ApiParam(value = "规则配置参数") ConfigRuleVO configRuleVO) {
        String objectType;
        if (null != configRuleVO) {
            objectType = configRuleVO.getObjectType();
        } else {
            return null;
        }
        List<String> list = warnRuleService.objectTypeHasRule(objectType);
        return ResponseResult.init(list);
    }

    @ApiOperation(value = "删除规则的对象类型",response = Integer.class)
    @ApiResponses({
            @ApiResponse(code = 200,message = "successful response")
    })
    @RequestMapping(value = BigDataPath.WARNRULE_OBJECTTYPE_DELETE,method = RequestMethod.DELETE)
    public ResponseResult<Integer> deleteObjectTypeOfRules(@RequestBody @ApiParam(value = "规则配置参数") ConfigRuleVO configRuleVO) {
        String objectType;
        List<String> ipcIdList;
        if (null != configRuleVO) {
            objectType = configRuleVO.getObjectType();
            ipcIdList = configRuleVO.getIpcIDs();
        } else {
            return null;
        }
        int i = warnRuleService.deleteObjectTypeOfRules(objectType, ipcIdList);
        return ResponseResult.init(i);
    }
}