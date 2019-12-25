package com.xt.pinyougou.service;

import com.xt.bean.Result;
import com.xt.pinyougou.entity.Brand;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 服务降级
 */
@Component
public class BrandClientServiceFallbackFactory implements FallbackFactory<BrandClientService> {
    @Override
    public BrandClientService create(Throwable throwable) {
        return new BrandClientService() {
            @Override
            public Brand get(Long id) {
                return new Brand().setId(id)
                        .setName("该ID：" + id + "没有对应的信息，Consumer客户端提供的降级信息，此刻服务Provider已经关闭")
                        .setFirstChar("Provider is down！");
            }

            @Override
            public List<Brand> list() {
                ArrayList<Brand> list = new ArrayList<>();
                list.add(new Brand().setId(null)
                        .setName("Consumer客户端提供的降级信息，此刻服务Provider已经关闭")
                        .setFirstChar("Provider is down！"));
                return list;
            }

            @Override
            public Result add(Brand brand) {
                return new Result(false, "Consumer客户端提供的降级信息，此刻服务Provider已经关闭");
            }

            @Override
            public Result update(Brand brand) {
                return new Result(false, "Consumer客户端提供的降级信息，此刻服务Provider已经关闭");
            }

            @Override
            public Result delete(Long id) {
                return new Result(false, "Consumer客户端提供的降级信息，此刻服务Provider已经关闭");
            }
        };
    }
}
