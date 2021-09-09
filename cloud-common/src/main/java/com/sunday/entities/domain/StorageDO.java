package com.sunday.entities.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ProjectName: springclouddemo
 * @Package: com.sunday.entities.domain
 * @ClassName: StorageDO
 * @Author: yangwendong
 * @Description:
 * @Date: 2021/9/9 14:42
 * @Version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StorageDO {
    private Long id;
    private Long productId;
    private Integer total;
    private Integer used;
    private Integer residue;
}
