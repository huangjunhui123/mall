package com.macro.mall.demo.demo.service;

import com.baomidou.mybatisplus.service.IService;
import com.macro.mall.demo.demo.bo.PmsBrandPageListResVo;
import com.macro.mall.demo.demo.bo.common.PageView;
import com.macro.mall.demo.demo.bo.common.PmsBrandInfoResVo;
import com.macro.mall.demo.demo.bo.req.AddPmsBrandReqVo;
import com.macro.mall.demo.demo.bo.req.PmsBrandPageListReqVo;
import com.macro.mall.demo.demo.model.PmsBrandEntity;

import java.util.List;

/**
 * DemoService接口
 *
 * @author macro
 * @date 2019/4/8
 */
public interface DemoService extends IService<PmsBrandEntity> {
    /**
     * 列表
     * @return
     */
    List<PmsBrandPageListResVo> listAllBrand();

    /**
     * 新增
     * @param pmsBrandDto
     */
    void createBrand(AddPmsBrandReqVo pmsBrandDto);

    /**
     * 修改
     * @param pmsBrandDto
     */
    void updateBrand(AddPmsBrandReqVo pmsBrandDto);

    /**
     * 删除
     * @param id
     * @return
     */
    int deleteBrand(Long id);

    /**
     * 分页列表
     * @param vo
     * @return
     */
    PageView<PmsBrandPageListResVo> listBrand(PmsBrandPageListReqVo vo);

    /**
     * 详情信息
     * @param id
     * @return
     */
    PmsBrandInfoResVo getBrand(Long id);
}
