package com.macro.mall.demo.demo.bo.common;

import com.baomidou.mybatisplus.plugins.Page;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Collections;
import java.util.List;

/**
 * 分页结果内容封装
 *
 * @author panhong.
 * @time 2020/4/13 0013.
 */
@Data
public class PageView<T> {

    @ApiModelProperty(value = "页数", example = "1")
    private Integer pageNum;
    @ApiModelProperty(value = "页面大小", example = "10")
    private Integer pageSize;
    @ApiModelProperty(value = "总页数", example = "10")
    private Integer pageTotal;
    @ApiModelProperty(value = "总条数", example = "10")
    private Integer recordTotal;
    @ApiModelProperty("数据")
    private List<T> list;

    public PageView() {
    }

    public PageView(Page page) {
        if (null == page) {
            this.setList(Collections.emptyList());
            this.setPageTotal(0);
            this.setRecordTotal(0);
        } else {
            this.setList(page.getRecords());
            this.setPageTotal(page.getPages());
            this.setRecordTotal(page.getTotal());
        }
        this.setPageSize(page.getSize());
        this.setPageNum(page.getCurrent());
    }
}
