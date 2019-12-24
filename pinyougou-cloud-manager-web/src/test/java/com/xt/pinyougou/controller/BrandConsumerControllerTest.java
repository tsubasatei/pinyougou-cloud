package com.xt.pinyougou.controller;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * 启动服务 pinyougou-cloud-sellergoods-provider
 * 再进行测试
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc //该注解将会自动配置mockMvc的单元测试
public class BrandConsumerControllerTest {

    @Autowired
    private MockMvc mockMvc; //自动注入mockMvc的对象

    @Test
    public void test () {
        System.out.println(mockMvc);
    }

    @Test
    public void testGet () throws Exception {
        String result = mockMvc.perform(get("/consumer/brand/1").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    @Test
    public void testList () throws Exception {
        String result = mockMvc.perform(get("/consumer/brand/list").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result = " + result);
    }

    @Test
    public void testAdd () throws Exception {
        String content = "{\"name\":\"骆驼\",\"firstChar\":\"L\"}";
        String result = mockMvc.perform(post("/consumer/brand").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.id").value("1"))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result: " + result);
    }

    @Test
    public void testUpdate () throws Exception {
        String content = "{\"id\":\"44\",\"name\":\"骆驼2\",\"firstChar\":\"L\"}";
        String result = mockMvc.perform(put("/consumer/brand").contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(content))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("result: " + result);
    }

    @Test
    public void testDelete () throws Exception {
        String result = mockMvc.perform(delete("/consumer/brand/42").contentType(MediaType.APPLICATION_JSON_UTF8))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        System.out.println("result: " + result);
    }
}
