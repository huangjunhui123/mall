package com.macro.mall.demo.demo.controller;

import com.macro.mall.demo.demo.bo.PmsBrandPageListResVo;
import com.macro.mall.demo.demo.bo.common.PageView;
import com.macro.mall.demo.demo.bo.common.PmsBrandInfoResVo;
import com.macro.mall.demo.demo.bo.req.AddPmsBrandReqVo;
import com.macro.mall.demo.demo.bo.req.PmsBrandPageListReqVo;
import com.macro.mall.demo.demo.common.MessageResponse;
import com.macro.mall.demo.demo.service.DemoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 黄俊辉
 */
@Api(value = "品牌管理测试案例", tags = "品牌管理测试案例")
@RestController
@RequestMapping("/case")
public class DemoController {
    @Autowired
    private DemoService demoService;

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

    @ApiOperation(value = "获取全部品牌列表")
    @RequestMapping(value = "/brand/listAll", method = RequestMethod.GET)
    public MessageResponse<List<PmsBrandPageListResVo>> getBrandList() {
        return MessageResponse.data(demoService.listAllBrand());
    }

    @ApiOperation(value = "添加品牌")
    @RequestMapping(value = "/brand/create", method = RequestMethod.POST)
    public MessageResponse createBrand(@Validated AddPmsBrandReqVo pmsBrand) {
        demoService.createBrand(pmsBrand);
        return MessageResponse.data();
    }

    @ApiOperation(value = "更新品牌")
    @RequestMapping(value = "/brand/update/{id}", method = RequestMethod.POST)
    public MessageResponse updateBrand(@Validated AddPmsBrandReqVo pmsBrandDto) {
        demoService.updateBrand(pmsBrandDto);
        return MessageResponse.data();
    }

    @ApiOperation(value = "删除品牌")
    @RequestMapping(value = "/brand/delete/{id}", method = RequestMethod.GET)
    public MessageResponse deleteBrand(@PathVariable("id") Long id) {
        demoService.deleteBrand(id);
        return MessageResponse.data();
    }

    @ApiOperation(value = "分页获取品牌列表")
    @RequestMapping(value = "/brand/list", method = RequestMethod.GET)
    public MessageResponse<PageView<PmsBrandPageListResVo>> listBrand(PmsBrandPageListReqVo vo) {
        PageView<PmsBrandPageListResVo> brandList = demoService.listBrand(vo);
        return MessageResponse.data(brandList);
    }

    @ApiOperation(value = "根据编号查询品牌信息")
    @RequestMapping(value = "/brand/{id}", method = RequestMethod.GET)
    public MessageResponse<PmsBrandInfoResVo> brand(@PathVariable("id") Long id) {
        return MessageResponse.data(demoService.getBrand(id));
    }
}
