package cn.hello.b.controller;

import com.alibaba.nacos.api.exception.NacosException;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@Log
@RefreshScope
public class BController {

    @Value("${whoami:unkonwn}")
    private String whoami;

//    @Autowired
//    private RestTemplate restTemplate;

    @PostMapping(path = "/b/tryme")
    public Map<String, String> tryme(@RequestBody Map<String, String> req) throws NacosException {
        Map<String, String> res = new HashMap<>();
        res.put("abc", "def");
        res.put("whoami", whoami);
        System.out.println("who am I : " + whoami);

//        Map<String, String> resFromC = restTemplate.postForObject("http://hello_c/c/confirm", res, Map.class);
//        System.out.println(resFromC);

//        return resFromC;
        return res;
    }
}
