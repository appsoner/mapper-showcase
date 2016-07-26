package com.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Strings;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import lombok.SneakyThrows;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

/**
 * @Author xgs.
 * @Email xgs@terminus.io
 * @Date 16/7/25
 */

@Data
@Table(name = "galaxy_user_shop_addresses")
public class ShopAddress implements Serializable {
    private static final long serialVersionUID = 485791797593817519L;
    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Id
    @GeneratedValue
    private Long id;

    /**
     * 店铺id
     */
    private Long shopId;

    /**
     * 店铺名
     */
    private String shopName;

    /**
     * 电话
     */
    private String phone;

    private String province;

    private String city;

    private String region;

    private String street;

    private String detail;

    private Integer status;

    @Setter(AccessLevel.NONE)
    @JsonIgnore
    private String extraJson;

    @Setter(AccessLevel.NONE)
    @Transient
    private Map<String, String> extra;

    private Date createdAt;

    private Date updatedAt;

    @SneakyThrows
    public void setExtra(Map<String, String> extra) {
        this.extra = extra;
        if (extra == null || extra.isEmpty()) {
            this.extraJson = null;
        } else {
            this.extraJson = OBJECT_MAPPER.writeValueAsString(extra);
        }
    }

    @SneakyThrows
    public void setExtraJson(String extraJson) {
        this.extraJson = extraJson;
        if (Strings.isNullOrEmpty(extraJson)) {
            this.extra = Collections.emptyMap();
        } else {
            this.extra = OBJECT_MAPPER.readValue(extraJson,Map.class);
        }
    }
}
