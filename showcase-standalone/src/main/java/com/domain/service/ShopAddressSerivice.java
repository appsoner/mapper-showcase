package com.domain.service;

import com.domain.dao.ShopAddressMapper;
import com.domain.model.ShopAddress;
import com.google.common.base.Throwables;
import io.terminus.common.model.Paging;
import io.terminus.common.model.Response;
import io.terminus.mapper.entity.Example;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xgs.
 * @Email xgs@terminus.io
 * @Date 16/7/25
 */

@Service
@Slf4j
public class ShopAddressSerivice {

    private final ShopAddressMapper shopAddressMapper;

    @Autowired
    public ShopAddressSerivice(ShopAddressMapper shopAddressMapper) {
        this.shopAddressMapper = shopAddressMapper;
    }

    public Response<Paging<ShopAddress>> pageByExample(String province, String shopName, Integer pageNo, Integer pageSize){
        try {
            ShopAddress shopAddress = new ShopAddress();
            shopAddress.setProvince(province);
            Example example = new Example(ShopAddress.class);
            example.createCriteria().andEqualTo(shopAddress).andLike("shopName", "%" + shopName + "%");

            Paging<ShopAddress> paging = shopAddressMapper.pagingByExample(example, pageNo, pageSize).getPaging();
            return Response.ok(paging);
        } catch (Exception e) {
            log.error("shopAddress pageByExample failed, province={}, shopName={}, pageNo={}, pageSize={}, error={}",
                    province, shopName, pageNo, pageSize, Throwables.getStackTraceAsString(e));
            return Response.fail("shopAddress.paging.failed");
        }
    }

}
