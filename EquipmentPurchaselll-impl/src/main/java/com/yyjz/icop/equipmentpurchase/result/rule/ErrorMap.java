package com.yyjz.icop.equipmentpurchase.result.rule;

import com.yyjz.icop.equipmentpurchase.result.vo.EquipmentTenderResultListSubVO;

import java.util.List;

public class ErrorMap {
    int errorNumbers;    //记录错误行数
    List<EquipmentTenderResultListSubVO> list;   //返回列表
    int numbers; //记录正确行数
    List <String> stringList;//记录错误信息
    String errorDetail;

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(List <String> stringList) {
        for(int i=0;i<stringList.size();i++){
            this.errorDetail =  this.errorDetail +stringList.get(i);
        }

    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public int getErrorNumbers() {
        return errorNumbers;
    }

    public void setErrorNumbers(int errorNumbers) {
        this.errorNumbers = errorNumbers;
    }

    public int getNumbers() {
        return numbers;
    }

    public void setNumbers(List<EquipmentTenderResultListSubVO> list) {
        this.numbers = this.list.size();
    }

    public List<EquipmentTenderResultListSubVO> getList() {
        return list;
    }

    public void setList(List<EquipmentTenderResultListSubVO> list) {
        this.list = list;
    }
}
