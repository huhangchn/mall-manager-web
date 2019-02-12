package com.github.huhangchn.service;
import com.github.huhangchn.dto.AddressDto;
import com.github.huhangchn.model.Address;
import com.github.huhangchn.core.Service;

import java.util.List;


/**
* Created by CodeGenerator on 2019/02/12.
*/
public interface AddressService extends Service<Address> {

    List<AddressDto> getAddressList(Long userId);

    AddressDto getAddress(Long addressId);

    int addAddress(AddressDto addressDto);

    int updateAddress(AddressDto addressDto);

    int delAddress(AddressDto addressDto);

    void setAddressDefaultFalse(Integer userId);
}
