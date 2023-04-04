package com.github.emraxxor.ivip.pub.controller;

import com.github.emraxxor.ivip.api.pub.service.PublicServiceIF;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/public-service")
public class PublicServiceController implements PublicServiceIF {



    @GetMapping("/test")
    public String name() {
        return "Test";
    }

    @GetMapping("/add")
    public String add() {

        return "";
    }
}
