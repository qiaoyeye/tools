//package com.restful.up.dao.impl;
//
//import com.restful.up.dao.OperationCaseDao;
//import com.restful.up.model.CaseModel;
//import com.restful.up.service.OperationCaseService;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//
//
//public class OperationCaseServiceI implements OperationCaseService {
//
//    @Autowired
//    OperationCaseDao operationCaseDao;
//
//    public int addCase(CaseModel caseModel) {
//       return operationCaseDao.addCase( caseModel );
//    }
//
//    public List<CaseModel> queryCase() {
//        return operationCaseDao.queryCase();
//    }
//
//    public int delCase(int id){
//        return operationCaseDao.delOne(id);
//    }
//
//    public CaseModel queryOne(int id ){
//        return operationCaseDao.queryOne(id);
//    }
//
//    public int updateresult(int id,String result){
//        return operationCaseDao.updateresult(id,result);
//    }
//
//}
