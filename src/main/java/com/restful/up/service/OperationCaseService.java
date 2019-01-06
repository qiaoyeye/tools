package com.restful.up.service;

import com.restful.up.dao.OperationCaseDao;
import com.restful.up.model.CaseModel;
import com.restful.up.model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OperationCaseService {

    @Autowired
    OperationCaseDao operationCaseDao;

    public int addCase(CaseModel caseModel) {
       return operationCaseDao.addCase( caseModel );
    }

    public List<CaseModel> queryCase() {
        return operationCaseDao.queryCase();
    }

    public int delCase(int id){
        return operationCaseDao.delOne(id);
    }

    public CaseModel queryOne(int id ){
        return operationCaseDao.queryOne(id);
    }

    public int updateresult(int id,String response){
        CaseModel caseModel = new CaseModel();
        caseModel.setCaseResult( response );
        caseModel.setId( id );
        return operationCaseDao.updateresult(caseModel);
    }

}
