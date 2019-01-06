package com.restful.up.dao;

import com.restful.up.model.CaseModel;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public interface OperationCaseDao {

    int addCase(CaseModel caseModel);

    List<CaseModel> queryCase();


    int delOne(int id);

    CaseModel queryOne(int id);

    int updateresult(CaseModel caseModel);
}
