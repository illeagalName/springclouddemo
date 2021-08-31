package com.sunday.entities.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author yangwendong
 * @Date 2021/8/28 12:11 下午
 */
@Data
public class PaymentDO implements Serializable {
    private Long id;
    private String serialNum;
}
