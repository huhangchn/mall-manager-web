package com.github.huhangchn.front.controller;

import com.github.huhangchn.dto.AllGoodsResult;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
@Api(description = "商品页面")
public class FrontGoodsController {

    @Autowired
    private ContentService contentService;

    @RequestMapping(value = "/allGoods",method = RequestMethod.GET)
    @ApiOperation(value = "所有商品")
    public Result getAllProduct(@RequestParam(defaultValue = "1") int page,
                                                @RequestParam(defaultValue = "20") int size,
                                                @RequestParam(defaultValue = "") String sort,
                                                @RequestParam(defaultValue = "") Long cid,
                                                @RequestParam(defaultValue = "-1") int priceGt,
                                                @RequestParam(defaultValue = "-1") int priceLte){

        AllGoodsResult allGoodsResult=contentService.getAllProduct(page,size,sort,cid,priceGt,priceLte);
        return ResultFactory.success(allGoodsResult);
    }
    @RequestMapping(value = "/productDet",method = RequestMethod.GET)
    @ApiOperation(value = "商品详情")
    public Result getAllProduct(@RequestParam Integer productId){
        return ResultFactory.success(contentService.getProductDetail(productId));
    }

}