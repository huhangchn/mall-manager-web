package com.github.huhangchn.front.controller;


import com.github.huhangchn.dto.AddressDto;
import com.github.huhangchn.result.Result;
import com.github.huhangchn.result.ResultFactory;
import com.github.huhangchn.service.AddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api(description = "收货地址")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/user/addressList",method = RequestMethod.POST)
    @ApiOperation(value = "获得所有收货地址")
    public Result addressList(@RequestBody AddressDto addressDto){
        List<AddressDto> list=addressService.getAddressList(addressDto.getUserId());
        return ResultFactory.success(list);
    }

    @RequestMapping(value = "/user/address",method = RequestMethod.POST)
    @ApiOperation(value = "通过id获得收货地址")
    public Result address(@RequestBody AddressDto addressDto){

        AddressDto address=addressService.getAddress(addressDto.getAddressId());
        return ResultFactory.success(address);
    }

    @RequestMapping(value = "/user/addAddress",method = RequestMethod.POST)
    @ApiOperation(value = "添加收货地址")
    public Result addAddress(@RequestBody AddressDto addressDto){

        int result=addressService.addAddress(addressDto);
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/user/updateAddress",method = RequestMethod.POST)
    @ApiOperation(value = "编辑收货地址")
    public Result updateAddress(@RequestBody AddressDto addressDto){
        int result=addressService.updateAddress(addressDto);
        return ResultFactory.success(result);
    }

    @RequestMapping(value = "/user/delAddress",method = RequestMethod.POST)
    @ApiOperation(value = "删除收货地址")
    public Result delAddress(@RequestBody AddressDto addressDto){

        int result=addressService.delAddress(addressDto);
        return ResultFactory.success(result);
    }
}
