package com.nmefc.grid_monitor_service.service.serviceImpl;

import com.nmefc.grid_monitor_service.bean.BaseFileInfo;
import com.nmefc.grid_monitor_service.bean.DictBase;
import com.nmefc.grid_monitor_service.bean.DictBaseExample;
import com.nmefc.grid_monitor_service.bean.resultBean.GroupInfo;
import com.nmefc.grid_monitor_service.bean.resultBean.ProductInfo;
import com.nmefc.grid_monitor_service.mapper.BaseFileInfoMapper;
import com.nmefc.grid_monitor_service.mapper.DictBaseMapper;
import com.nmefc.grid_monitor_service.service.BaseFileInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service("baseFileInfoService")
public class BaseFileInfoServiceImpl implements BaseFileInfoService {
    @Autowired
    BaseFileInfoMapper baseFileInfoMapper;
    @Autowired
    DictBaseMapper dictBaseMapper;
    @Override
    public List<ProductInfo> getProductInfo() {

        List<ProductInfo> productInfoList = new ArrayList<>();
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();
        try{
            baseFileInfoList = baseFileInfoMapper.getAllElements();
        }catch (Exception e){
            throw e;
        }
        List<DictBase> dictBaseList = new ArrayList<>();
        DictBaseExample dictBaseExample = new DictBaseExample();
        try {
            dictBaseList = dictBaseMapper.selectByExample(dictBaseExample);
        }catch (Exception e){
            throw e;
        }
        if (dictBaseList.size()>0 && baseFileInfoList.size()>0){
            for(BaseFileInfo item : baseFileInfoList){
                for(DictBase dictItem : dictBaseList){
                    if (item.getIssurerId().equals(dictItem.getCode())){
                        ProductInfo productInfo = new ProductInfo(item.getIssurerId(),dictItem.getRemarks());
                        productInfoList.add(productInfo);
                    }
                }
            }
        }

        return productInfoList;
    }

    @Override
    public List<GroupInfo> getGroupInfo() {
        List<GroupInfo> groupInfoList = new ArrayList<>();
        List<BaseFileInfo> baseFileInfoList = new ArrayList<>();
        try{
            baseFileInfoList = baseFileInfoMapper.getAllGroups();
        }catch (Exception e){
            throw e;
        }
        List<DictBase> dictBaseList = new ArrayList<>();
        DictBaseExample dictBaseExample = new DictBaseExample();
        try {
            dictBaseList = dictBaseMapper.selectByExample(dictBaseExample);
        }catch (Exception e){
            throw e;
        }
        if (dictBaseList.size()>0 && baseFileInfoList.size()>0){
            for(BaseFileInfo item : baseFileInfoList){
                for(DictBase dictItem : dictBaseList){
                    if (item.getIssurerId().equals(dictItem.getCode())){
                        GroupInfo groupInfo = new GroupInfo(item.getIssurerId(),dictItem.getRemarks());
                        groupInfoList.add(groupInfo);
                    }
                }
            }
        }

        return groupInfoList;
    }
}
