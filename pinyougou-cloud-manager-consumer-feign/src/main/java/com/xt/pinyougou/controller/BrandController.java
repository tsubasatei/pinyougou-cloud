package com.xt.pinyougou.controller;


import com.xt.bean.Result;
import com.xt.pinyougou.entity.Brand;
import com.xt.pinyougou.service.BrandClientService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xt
 * @since 2019-12-24
 */
@Api(value = "brand", description = "品牌管理-消费端")
@RestController
@RequestMapping("/consumer/brand")
public class BrandController {


    @Autowired
    private BrandClientService service;

    @ApiOperation(value = "查询品牌详细信息", notes = "品牌详情")
    @GetMapping("/{id}")
    public Brand get(@ApiParam(value = "品牌ID", required = true) @PathVariable("id") Long id) {
        return service.get(id);
    }

    @ApiOperation(value = "获得品牌列表", notes = "列表信息")
    @GetMapping("/list")
    public List<Brand> list() {
        return service.list();
    }

    @ApiOperation(value = "添加品牌", notes = "添加品牌")
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        return service.add(brand);
    }

    @ApiOperation(value = "添加品牌", notes = "添加品牌")
    @PutMapping
    public Result update(@RequestBody Brand brand) {
        return service.update(brand);
    }

    @ApiOperation(value = "删除品牌", notes = "删除品牌")
    @DeleteMapping("/{id}")
    public Result delete(@ApiParam(value = "品牌ID", required = true) @PathVariable("id") Long id) {
        return service.delete(id);
    }
}

