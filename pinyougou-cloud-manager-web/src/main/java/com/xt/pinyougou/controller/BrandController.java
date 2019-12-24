package com.xt.pinyougou.controller;


import com.xt.bean.Result;
import com.xt.pinyougou.entity.Brand;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;

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

    public static final String BRAND_URL_PREFIX = "http://localhost:8001/brand";
    @Autowired
    private RestTemplate restTemplate;

    @ApiOperation(value = "查询品牌详细信息", notes = "品牌详情")
    @GetMapping("/{id}")
    public Brand get(@ApiParam(value = "品牌ID", required = true) @PathVariable("id") Long id) {
        return restTemplate.getForObject(BRAND_URL_PREFIX + "/" + id, Brand.class);
    }

    @ApiOperation(value = "获得品牌列表", notes = "列表信息")
    @GetMapping("/list")
    public List<Brand> list() {
        return restTemplate.getForObject(BRAND_URL_PREFIX + "/list", List.class);
    }

    @ApiOperation(value = "添加品牌", notes = "添加品牌")
    @PostMapping
    public Result add(@RequestBody Brand brand) {
        return restTemplate.postForObject(BRAND_URL_PREFIX, brand, Result.class);
    }

    @ApiOperation(value = "添加品牌", notes = "添加品牌")
    @PutMapping
    public Result update(@RequestBody Brand brand) {
        return restTemplate.postForObject(BRAND_URL_PREFIX, brand, Result.class);
    }

    @ApiOperation(value = "删除品牌", notes = "删除品牌")
    @DeleteMapping("/{id}")
    public Result delete(@ApiParam(value = "品牌ID", required = true) @PathVariable("id") Long id) {
        ResponseEntity<Result> responseEntity = restTemplate.exchange(BRAND_URL_PREFIX + "/" + id, HttpMethod.DELETE, null, Result.class);
        return responseEntity.getBody();
    }
}

