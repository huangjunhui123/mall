package com.macro.mall.demo.demo.bo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author 黄俊辉
 */
@Data
public class MutilFileInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull(message = "车型不能为空")
    @ApiModelProperty(value = "车型")
    private String model;

    @ApiModelProperty(value = "文件名称")
    private String name;

    @ApiModelProperty(value = "文件总大小")
    private Long totalSize;

    @Min(value = 1, message = "不能小于1")
    @Max(value = 10000, message = "不能大于10000")
    @ApiModelProperty(value = "当前分片序号")
    private Integer chunk;

    @Min(value = 1, message = "不能小于1")
    @Max(value = 10000, message = "不能大于10000")
    @ApiModelProperty(value = "分片总数")
//    @Cacheable(value = "1", key = "12")
    private Integer chunks;
}
