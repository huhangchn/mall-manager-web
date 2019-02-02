package com.github.huhangchn.service.impl;

import com.github.huhangchn.core.AbstractService;
import com.github.huhangchn.dao.GoodsAttributeValueMapper;
import com.github.huhangchn.dto.GoodsIdValuesDto;
import com.github.huhangchn.model.GoodsAttributeValue;
import com.github.huhangchn.service.GoodsAttributeValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by CodeGenerator on 2019/02/01.
 */
@Service
@Transactional
public class GoodsAttributeValueServiceImpl extends AbstractService<GoodsAttributeValue> implements GoodsAttributeValueService {
    @Autowired
    private GoodsAttributeValueMapper valueMapper;

    @Override
    public int deleteByGoodsId(Integer goodsId) {
        return valueMapper.deleteByGoodsId(goodsId);
    }

    @Override
    public List<Integer> findGoodsIdsByAllValueIdList(List<Integer> needValueIdList) {
        List<Integer> goodsIdList = new ArrayList<>();

//        List<GoodsIdValuesDto> dtoList = valueMapper.selectAllGoodsIdValues();
        List<GoodsIdValuesDto> dtoList = new ArrayList<>();
        List<GoodsAttributeValue> values = valueMapper.selectAll();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (GoodsAttributeValue value : values) {
            Integer goodsId = value.getGoodsId();
            Integer valueId = value.getValueId();
            List<Integer> list = map.get(goodsId);
            if (list == null) {
                list = new ArrayList<>();
                map.put(goodsId, list);
            }
            list.add(valueId);
        }
/*        for(Map.Entry<Integer, List<Integer>> entry : map.entrySet()){
            Integer key = entry.getKey();
            List<Integer> value = entry.getValue();
            GoodsIdValuesDto dto = new GoodsIdValuesDto();
            dto.setGoodsId(key);
            dto.setValueIdList(value);
            dtoList.add(dto);
        }*/

        a:for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            Integer goodsId = entry.getKey();
            List<Integer> valueIdList = entry.getValue();
            for (Integer valueId : needValueIdList) {
                if (!valueIdList.contains(valueId)) {
                    continue a;
                }
            }
            goodsIdList.add(goodsId);
        }
        return goodsIdList;

    }
//        a:for (GoodsIdValuesDto dto : dtoList) {
//            Integer goodsId = dto.getGoodsId();
//            List<Integer> valueIdList = dto.getValueIdList();
//
//            for (Integer valueId : needValueIdList) {
//                if(!valueIdList.contains(valueId)){
//                    goodsIdList.add(goodsId);
//                    continue a;
//                }
//            }
//        }
//        return goodsIdList;
//    }
}
