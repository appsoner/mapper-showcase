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

import java.util.Date;
import java.util.List;

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

    public Response<Paging<ShopAddress>> pageByEntity(String province, Integer pageNo, Integer pageSize){
        try {
            ShopAddress shopAddress = new ShopAddress();
            shopAddress.setProvince(province);
            Paging<ShopAddress> paging = shopAddressMapper.pagingByEntity(shopAddress, pageNo, pageSize).getPaging();
            return Response.ok(paging);
        } catch (Exception e) {
            log.error("shopAddress pageByExample failed, province={}, pageNo={}, pageSize={}, error={}",
                    province, pageNo, pageSize, Throwables.getStackTraceAsString(e));
            return Response.fail("shopAddress.paging.failed");
        }
    }

    public Response<Long> insert(String shopName, String detail, Long shopId){
        try {
            ShopAddress shopAddress = new ShopAddress();
            shopAddress.setShopName(shopName);
            shopAddress.setDetail(detail);
            shopAddress.setShopId(shopId);
            shopAddress.setCreatedAt(new Date());
            shopAddress.setUpdatedAt(new Date());
            shopAddressMapper.insert(shopAddress);
            return Response.ok(shopAddress.getId());
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail("insert.failed");
        }
    }

    public Response<List<ShopAddress>> select(String province){
        try {
            ShopAddress shopAddress = new ShopAddress();
            shopAddress.setProvince(province);
            return Response.ok(shopAddressMapper.select(shopAddress));
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail("select.failed");
        }
    }

    public Response<Boolean> update(ShopAddress shopAddress){
        try {
            shopAddress.setUpdatedAt(new Date());
            return Response.ok(shopAddressMapper.updateByPrimaryKey(shopAddress)==1);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.fail("update.failed");
        }
    }


}
