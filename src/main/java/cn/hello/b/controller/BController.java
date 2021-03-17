package cn.hello.b.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BController {

    @PostMapping(path = "/b/try")
    public Map<String, String> done(@RequestBody Map<String, String> req) {
        Map<String, String> res = new HashMap<>();
        res.put("abc", "def");
        return res;
    }



}
