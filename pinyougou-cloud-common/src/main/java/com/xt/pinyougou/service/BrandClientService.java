package com.xt.pinyougou.service;

import com.xt.bean.Result;
import com.xt.pinyougou.entity.Brand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "PINYOUGOU-CLOUD-SELLERGOODS-PROVIDER", fallbackFactory = BrandClientServiceFallbackFactory.class)
public interface BrandClientService {

    @GetMapping("/brand/{id}")
    Brand get(@PathVariable("id") Long id);

    @GetMapping("/brand/list")
    List<Brand> list();

    @PostMapping("/brand")
    Result add(Brand brand);

    @PutMapping("/brand")
    Result update(@RequestBody Brand brand);

    @DeleteMapping("/brand/{id}")
    Result delete(@PathVariable("id") Long id);
}
