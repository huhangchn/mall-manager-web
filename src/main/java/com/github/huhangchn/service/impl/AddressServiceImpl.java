package com.github.huhangchn.service.impl;

import com.github.huhangchn.dao.AddressMapper;
import com.github.huhangchn.dto.AddressDto;
import com.github.huhangchn.dto.DtoUtil;
import com.github.huhangchn.model.Address;
import com.github.huhangchn.service.AddressService;
import com.github.huhangchn.core.AbstractService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
* Created by CodeGenerator on 2019/02/12.
*/
@Service
@Transactional
public class AddressServiceImpl extends AbstractService<Address> implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<AddressDto> getAddressList(Long userId) {
        List<Address> addressList = addressMapper.selectByUserId(userId);
        return addressList2AddressDtoList(addressList);
    }

    private List<AddressDto> addressList2AddressDtoList(List<Address> addressList) {
        List<AddressDto> addressDtoList = new ArrayList<>();
        for (Address address : addressList) {
            AddressDto addressDto = DtoUtil.Address2AddressDto(address);
            addressDtoList.add(addressDto);
        }
        return addressDtoList;
    }

    @Override
    public AddressDto getAddress(Long addressId) {
        Address address = addressMapper.selectByPrimaryKey(addressId);
        return DtoUtil.Address2AddressDto(address);
    }

    @Override
    public int addAddress(AddressDto addressDto) {
        Address address = DtoUtil.addressDto2Address(addressDto);
        if(address.getIsDefault()){
            setAddressDefaultFalse(address.getUserId());
        }
        return addressMapper.insertSelective(address);
    }

    @Override
    public int updateAddress(AddressDto addressDto) {
        Address address = DtoUtil.addressDto2Address(addressDto);
        if(address.getIsDefault()){
            setAddressDefaultFalse(address.getUserId());
        }
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public int delAddress(AddressDto addressDto) {
        return addressMapper.deleteByPrimaryKey(addressDto.getAddressId());
    }

    @Override
    public void setAddressDefaultFalse(Integer userId) {
        addressMapper.setAddressDefaultFalse(userId);
    }
}
