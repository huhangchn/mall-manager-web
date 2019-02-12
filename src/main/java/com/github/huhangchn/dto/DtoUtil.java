package com.github.huhangchn.dto;

import com.github.huhangchn.model.Address;
import com.github.huhangchn.model.AttributeValue;
import com.github.huhangchn.model.Goods;
import com.github.huhangchn.model.OrdersSku;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class DtoUtil {
    public static Product Goods2Product(Goods goods) {
        Product product = new Product();
        product.setProductId(goods.getId());
        product.setProductName(goods.getName());
        product.setSubTitle(goods.getBrief());
        product.setSalePrice(goods.getPrice());
        product.setProductImageBig(goods.getPicUrl());
        return product;
    }

    public static ProductDetail Goods2ProductDetail(Goods goods) {
        ProductDetail productDetail = new ProductDetail();
        productDetail.setProductId(goods.getId());
        productDetail.setProductName(goods.getName());
        productDetail.setSubTitle(goods.getBrief());
        productDetail.setDetail(goods.getDetail());
        productDetail.setSalePrice(goods.getPrice());
        productDetail.setProductImageBig(goods.getPicUrl());
        String gallery = goods.getGallery();
        if(StringUtils.isNotEmpty(gallery)){
            productDetail.setProductImageSmall(Arrays.asList(gallery.split(",")));
        }
        return productDetail;
    }


    public static List<AttributeFront> AttributeDto2AttributeFront(List<AttributeDto> attributeDtoList) {
        List<AttributeFront> attributeFrontList = new ArrayList<>();
        for (AttributeDto attributeDto : attributeDtoList) {
            AttributeFront attributeFront = new AttributeFront();

            for (AttributeValue attributeValue : attributeDto.getAttributeValue()) {

            }

            attributeFrontList.add(attributeFront);
        }
        return null;
    }

    public static OrderDto ordersModel2OrderDto(OrdersModel ordersModel) {
        OrderDto orderDto = new OrderDto();
        orderDto.setOrderId(Long.valueOf(ordersModel.getId()));
        AddressDto address = new AddressDto();
        address.setStreetName(ordersModel.getAddress());
        address.setTel(ordersModel.getMobile());
        address.setUserName(ordersModel.getName());
        orderDto.setAddressInfo(address);
        orderDto.setCloseDate(null);
        Date createTime = ordersModel.getCreateTime();
        String finishDate = ""+(createTime.getTime() + 24 * 60 * 60 * 1000);//一天订单付钱时间
        orderDto.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(createTime));
        orderDto.setFinishDate(finishDate);
        orderDto.setOrderStatus(ordersModel.getStatus());
        orderDto.setOrderTotal(ordersModel.getTotalPrice());
        List<CartProduct> cartProduct = OrdersSkuList2CartProductList(ordersModel.getOrdersSkuList());
        orderDto.setGoodsList(cartProduct);
        return orderDto;
    }

    private static List<CartProduct> OrdersSkuList2CartProductList(List<OrdersSku> ordersSkuList) {
        List<CartProduct> cartProductList = new ArrayList<>();
        for (OrdersSku ordersSku : ordersSkuList) {
            CartProduct cartProduct = ordersSku2CartProduct(ordersSku);
            cartProductList.add(cartProduct);
        }
        return cartProductList;
    }

    private static CartProduct ordersSku2CartProduct(OrdersSku ordersSku) {
        CartProduct cartProduct = new CartProduct();
        cartProduct.setProductId(Long.valueOf(ordersSku.getSkuId()));
        cartProduct.setProductName(ordersSku.getSkuName());
        cartProduct.setProductNum(Long.valueOf(ordersSku.getPurchaseNum()));
        cartProduct.setSalePrice(ordersSku.getSkuPrice());
        cartProduct.setProductImg(ordersSku.getSkuImage());
        return cartProduct;
    }

    public static AddressDto Address2AddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(Long.valueOf(address.getId()));
        addressDto.setStreetName(address.getAddress());
        addressDto.setTel(address.getMobile());
        addressDto.setUserId(Long.valueOf(address.getUserId()));
        addressDto.setUserName(address.getName());
        addressDto.setIsDefault(address.getIsDefault());
        return addressDto;
    }

    public static Address addressDto2Address(AddressDto addressDto) {
        Address address = new Address();
        Long addressId = addressDto.getAddressId();
        address.setId(addressId == null ? null : addressId.intValue());
        address.setAddress(addressDto.getStreetName());
        address.setMobile(addressDto.getTel());
        address.setUserId(Integer.valueOf(addressDto.getUserId().toString()));
        address.setName(addressDto.getUserName());
        address.setIsDefault(addressDto.getIsDefault());
        return address;
    }
}
