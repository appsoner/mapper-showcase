package com.domain.controller;

import com.domain.model.ShopAddress;
import com.domain.service.ShopAddressSerivice;
import io.terminus.common.exception.JsonResponseException;
import io.terminus.common.model.Paging;
import io.terminus.common.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created Date : 16/7/19
 * Author : wujianwei
 */
@RestController
@RequestMapping("/api/shopAddresses")
public class ShopAddresses {
    private final ShopAddressSerivice shopAddressSerivice;

    @Autowired
    public ShopAddresses(ShopAddressSerivice shopAddressSerivice) {
        this.shopAddressSerivice = shopAddressSerivice;
    }

    @RequestMapping(value = "pagingByExample", method = RequestMethod.GET)
    public Paging<ShopAddress> pageByExample(@RequestParam("province") String province,
                                             @RequestParam("shopName") String shopName,
                                             @RequestParam(required = false)Integer pageNo,
                                             @RequestParam(required = false)Integer pageSize){
        Response<Paging<ShopAddress>> response =
                shopAddressSerivice.pageByExample(province, shopName, pageNo, pageSize);
        if(response.isSuccess()){
            return response.getResult();
        }else{
            throw new JsonResponseException(response.getError());
        }
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}
