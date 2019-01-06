package com.restful.up.controller;


import com.restful.up.model.CaseModel;
import com.restful.up.service.HttpClientService;
import com.restful.up.service.OperationCaseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class OperationCase {

    @Autowired
    private OperationCaseService operationCaseService;
    @Autowired
    private HttpClientService httpClientService;



    @RequestMapping(value = "/addCase", method= RequestMethod.POST,produces="application/json")
    public int addCase(@RequestBody CaseModel caseModel) {
        return operationCaseService.addCase(caseModel);
    }

    //查询所以信息
    @RequestMapping(value = "/queryCase")
    public List<CaseModel> queryCase(){
        return operationCaseService.queryCase();
    }

    @RequestMapping(value = "/deleteCase")
    public int delCase(int id){
        return operationCaseService.delCase(id);
    }
    //根据ID查询单个信息
    @RequestMapping(value = "/queryOne")
    public CaseModel queryOne(int id ){
     return operationCaseService.queryOne(id);
    }

    //运行单个case
    @RequestMapping(value = "/runCase")
    public int runCase(int id){
        String response = null;
        int updateID = 0;
        CaseModel caseModel  =  operationCaseService.queryOne(id);
        String url = caseModel.getCaseUrl();
        String paramStr = caseModel.getCaseParam();
        String type = caseModel.getCaseType();
        if (type.equals( "GET" )){
            response =   httpClientService.runGet(paramStr,url);

            Map map =new HashMap(  );
            map.put( id,id );
            map.put( response,response );
            updateID =  operationCaseService.updateresult(id,response);
        }

        return updateID;
    }


}
