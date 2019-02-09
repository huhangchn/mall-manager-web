package com.github.huhangchn.front.controller;

import com.github.huhangchn.dto.CartDto;
import com.github.huhangchn.model.Cart;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@Api(description = "购物车")
public class CartController {
    @Autowired
    private CartService cartService;
    @RequestMapping(value = "/addCart",method = RequestMethod.POST)
    @ApiOperation(value = "添加购物车商品")
    public Result addCart(@RequestBody Cart cart){
        int count = cartService.countByUserIdAndSkuId(cart.getUserId(), cart.getSkuId());
        if(count == 1){
            cartService.addNumByUserIdAndSkuId(cart.getUserId(), cart.getSkuId(), cart.getNum());
        }else{
            cartService.saveSelective(cart);
        }
        return ResultFactory.success();
    }

    @RequestMapping(value = "/cartList",method = RequestMethod.POST)
    @ApiOperation(value = "获取购物车商品列表")
    public Result getCartList(@RequestBody Cart cart){

        List<CartDto> list=cartService.getCartList(cart.getUserId());
        return ResultFactory.success(list);
    }

    @RequestMapping(value = "/cartEdit",method = RequestMethod.POST)
    @ApiOperation(value = "编辑购物车商品")
    public Result updateCartNum(@RequestBody Cart cart){

        int result=cartService.updateByUserIdAndSkuId(cart.getUserId(),cart.getSkuId(),cart.getNum(), cart.getChecked());
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/editCheckAll",method = RequestMethod.POST)
    @ApiOperation(value = "是否全选购物车商品")
    public Result editCheckAll(@RequestBody Cart cart){

        int result=cartService.checkAll(cart.getUserId(),cart.getChecked());
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/cartDel",method = RequestMethod.POST)
    @ApiOperation(value = "删除购物车商品")
    public Result deleteCartItem(@RequestBody Cart cart){

        int result=cartService.deleteCartItem(cart.getUserId(),cart.getSkuId());
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/delCartChecked",method = RequestMethod.POST)
    @ApiOperation(value = "删除购物车选中商品")
    public Result delChecked(@RequestBody Cart cart){
        int result = cartService.delChecked(cart.getUserId());
        return ResultFactory.success(result);
    }

    @PostMapping
    public Result add(@RequestBody Cart cart) {
        return ResultFactory.success(cartService.saveSelective(cart));
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        return ResultFactory.success(cartService.deleteById(id));
    }

    @PutMapping
    public Result update(@RequestBody Cart cart) {
        return ResultFactory.success(cartService.updateByPrimaryKeySelective(cart));
    }

    @GetMapping("/{id}")
    public Result detail(@PathVariable Integer id) {
        return ResultFactory.success(cartService.findById(id));
    }

    @GetMapping
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
        return ResultFactory.success(cartService.findAll(page, size));
    }
}
