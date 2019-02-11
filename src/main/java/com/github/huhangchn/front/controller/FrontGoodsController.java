package com.github.huhangchn.front.controller;

import com.github.huhangchn.dto.AllGoodsResult;
import com.github.huhangchn.dto.GoodsFrontSearchDto;
import com.github.huhangchn.model.Brand;
import com.github.huhangchn.model.Category;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.BrandService;
import com.github.huhangchn.service.CategoryService;
import com.github.huhangchn.service.ContentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/goods")
@Api(description = "商品页面")
public class FrontGoodsController {

    @Autowired
    private ContentService contentService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/allGoods")
    @ApiOperation(value = "所有商品")
    public Result allGoods(@RequestParam(defaultValue = "1") int page,
                           @RequestParam(defaultValue = "20") int size,
                           @RequestParam(defaultValue = "") String sort,
                           @RequestParam(defaultValue = "") Long cid,
                           @RequestParam(defaultValue = "-1") int priceGt,
                           @RequestParam(defaultValue = "-1") int priceLte) {

        AllGoodsResult allGoodsResult = contentService.getAllProduct(page, size, sort, cid, priceGt, priceLte);
        return ResultFactory.success(allGoodsResult);
    }

    @GetMapping(value = "/productDet")
    @ApiOperation(value = "商品详情")
    public Result productDet(@RequestParam Integer productId) {
        return ResultFactory.success(contentService.getProductDetail(productId));
    }
    @GetMapping(value = "/productDetBySkuId")
    @ApiOperation(value = "通过skuId获取商品详情")
    public Result productDetBySkuId(@RequestParam Integer skuId) {
        return ResultFactory.success(contentService.getProductDetailBySkuId(skuId));
    }

    @GetMapping(value = "/goodsIdBySkuId")
    @ApiOperation(value = "通过skuId获取商品id")
    public Result goodsIdBySkuId(@RequestParam Integer skuId) {
        return ResultFactory.success(contentService.getGoodsIdBySkuId(skuId));
    }

    /**
     * 颜色，尺码的相关信息
     */
    @GetMapping(value = "/productSaleInfo")
    @ApiOperation(value = "颜色，尺码的相关信息")
    public Result productSaleInfo(@RequestParam Integer productId) {
        return ResultFactory.success(contentService.getProductSaleInfo(productId));
    }

    @GetMapping(value = "/attributeList")
    @ApiOperation(value = "商品属性分类")
    public Result getAttributeList() {
        return ResultFactory.success(contentService.getAttributeList());
    }

    @PostMapping(value = "/search")
    @ApiOperation(value = "条件搜索")
    public Result search(@RequestBody GoodsFrontSearchDto searchDto) {
        AllGoodsResult result = contentService.getBySearchDto(searchDto);
        return ResultFactory.success(result);
    }

    @GetMapping(value = "/searchByKey")
    @ApiOperation(value = "关键字搜索")
    public Result searchByKey(@RequestParam(defaultValue = "") String key,
                              @RequestParam(defaultValue = "1") int page,
                              @RequestParam(defaultValue = "20") int size) {
        if(StringUtils.isEmpty(key)){
            return ResultFactory.success();
        }
        AllGoodsResult result = contentService.findByKey(key, page,size);
        return ResultFactory.success(result);
    }


    @GetMapping(value = "/brandList")
    @ApiOperation(value = "品牌列表")
    public Result brandList() {
        List<Brand> result = brandService.findAll();
        return ResultFactory.success(result);
    }

    @GetMapping(value = "/categoryList")
    @ApiOperation(value = "分类列表")
    public Result categoryList() {
        List<Category> result = categoryService.findAll();
        return ResultFactory.success(result);
    }
}
