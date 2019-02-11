package com.github.huhangchn.model;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Accessors(chain = true)
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 订单编号,供用户查询
     */
    private String number;

    /**
     * 订单状态0未付款,1已付款,2已发货,3已签收,4退货申请,5退货中,6已退货,7取消交易
     */
    private String status;

    /**
     * 用户id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 行政区id
     */
    @Column(name = "region_id")
    private Integer regionId;

    /**
     * 收货人
     */
    private String name;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 商品总价
     */
    @Column(name = "total_price")
    private BigDecimal totalPrice;

    /**
     * 运费
     */
    @Column(name = "logistics_fee")
    private BigDecimal logisticsFee;

    /**
     * 订单总价
     */
    @Column(name = "order_price")
    private BigDecimal orderPrice;

    /**
     * 实付款，一般情况下和订单总价相同
     */
    @Column(name = "actual_pay")
    private BigDecimal actualPay;

    /**
     * 付款时间
     */
    @Column(name = "pay_time")
    private Date payTime;

    /**
     * 订单创建时间
     */
    @Column(name = "create_time")
    private Date createTime;

    /**
     * 发货时间
     */
    @Column(name = "delivery_time")
    private Date deliveryTime;

    /**
     * 成交时间,确认收货时间
     */
    @Column(name = "recipient_time")
    private Date recipientTime;

    /**
     * 支付渠道
     */
    @Column(name = "pay_channel")
    private String payChannel;

    /**
     * 第三方支付流水号
     */
    @Column(name = "escrow_trade_no")
    private String escrowTradeNo;

    /**
     * 物流名称
     */
    @Column(name = "rlogistics_channel")
    private String rlogisticsChannel;

    /**
     * 物流自动编号
     */
    @Column(name = "rlogistics_no")
    private String rlogisticsNo;


}