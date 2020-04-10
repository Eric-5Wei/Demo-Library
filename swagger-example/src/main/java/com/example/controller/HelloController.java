package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    @PostMapping
    public String updateHello(String str) {
        return str;
    }

    @DeleteMapping
    public String deleteHello(Integer id, Long idL, HttpSession session, HttpServletRequest request) {
        return "Delete OK";
    }
}
