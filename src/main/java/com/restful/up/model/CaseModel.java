package com.restful.up.model;

public class CaseModel {
   private int id;
   private String caseName ;
   private String caseType;
   private String caseUrl;
   private String caseParam;
   private String caseResult;
   private String caseCheck;
   private int isDel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public String getCaseType() {
        return caseType;
    }

    public void setCaseType(String caseType) {
        this.caseType = caseType;
    }

    public String getCaseUrl() {
        return caseUrl;
    }

    public void setCaseUrl(String caseUrl) {
        this.caseUrl = caseUrl;
    }

    public String getCaseParam() {
        return caseParam;
    }

    public void setCaseParam(String caseParam) {
        this.caseParam = caseParam;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public String getCaseCheck() {
        return caseCheck;
    }

    public void setCaseCheck(String caseCheck) {
        this.caseCheck = caseCheck;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
}
