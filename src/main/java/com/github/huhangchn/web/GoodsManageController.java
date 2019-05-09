package com.github.huhangchn.web;

import com.github.huhangchn.dto.GoodsInfoDto;
import com.github.huhangchn.model.Goods;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.GoodsService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

@RestController
@RequestMapping("/admin/goods")
public class GoodsManageController {
    @Autowired
    private GoodsService goodsService;

    @GetMapping("/list")
    public Result list(@RequestParam(required = false) String id,
                       @RequestParam(required = false) String name,
                       @RequestParam(required = false) Integer categoryId,
                       @RequestParam(required = false) Integer brandId,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit) {

        Condition condition = new Condition(Goods.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.andEqualTo("categoryId", categoryId)
                .andEqualTo("brandId", brandId);
        if(id != null){
            criteria.andLike("id", "%" + id + "%");
        }
        if(name != null){
            criteria .andLike("name", "%" + name + "%");
        }

        PageInfo<Goods> goodsPageInfo = goodsService.findAll(condition, page, limit);
        return ResultFactory.success(goodsPageInfo);
    }


    @PostMapping("/addOrUpdateGoods")
    public Result addOrUpdateGoods(@RequestBody GoodsInfoDto goodsInfoDto, @RequestParam Boolean edit){
        if(edit){
            goodsService.updateGoods(goodsInfoDto);
        }else{
            goodsService.addGoods(goodsInfoDto);
        }
        return ResultFactory.success();
    }

    @GetMapping("/goodsInfo/{goodsId}")
    public Result goodsInfo(@PathVariable("goodsId") Integer goodsId){
        return ResultFactory.success(goodsService.getGoodsInfo(goodsId));
    }

    @PutMapping("/changeGoodsSaleStatus")
    public Result changeGoodsSaleStatus(@RequestParam Integer goodsId, @RequestParam Boolean isOnSale){
        return ResultFactory.success(goodsService.updateGoodsSaleStatus(goodsId, isOnSale));
    }
}
