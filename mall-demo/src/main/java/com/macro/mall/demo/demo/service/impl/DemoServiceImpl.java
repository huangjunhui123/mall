package com.macro.mall.demo.demo.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.macro.mall.demo.demo.bo.PmsBrandPageListResVo;
import com.macro.mall.demo.demo.bo.common.PageView;
import com.macro.mall.demo.demo.bo.common.PmsBrandInfoResVo;
import com.macro.mall.demo.demo.bo.req.AddPmsBrandReqVo;
import com.macro.mall.demo.demo.bo.req.PmsBrandPageListReqVo;
import com.macro.mall.demo.demo.dao.PmsBrandDao;
import com.macro.mall.demo.demo.model.PmsBrandEntity;
import com.macro.mall.demo.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * DemoService实现类
 *
 * @author macro
 * @date 2019/4/8
 */
@Service
public class DemoServiceImpl extends ServiceImpl<PmsBrandDao, PmsBrandEntity> implements DemoService {

    @Autowired
    private PmsBrandDao pmsBrandDao;

    @Override
    public List<PmsBrandPageListResVo> listAllBrand() {
        return null;
    }

    @Override
    public void createBrand(AddPmsBrandReqVo pmsBrandDto) {

    }

    @Override
    public void updateBrand(AddPmsBrandReqVo pmsBrandDto) {

    }

    @Override
    public int deleteBrand(Long id) {
        return 0;
    }

    @Override
    public PageView<PmsBrandPageListResVo> listBrand(PmsBrandPageListReqVo vo) {
        return null;
    }

    @Override
    public PmsBrandInfoResVo getBrand(Long id) {
        return null;
    }
}
