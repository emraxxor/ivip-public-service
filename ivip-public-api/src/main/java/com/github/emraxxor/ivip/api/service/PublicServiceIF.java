package com.github.emraxxor.ivip.api.service;

import com.github.emraxxor.ivip.common.feign.clients.IvipPublicFeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@IvipPublicFeignClient(
        name = "ivip-public-service",
        url = "${ivip.services.public.address}/public-service"
)
public interface PublicServiceIF {

    @GetMapping("/test")
    String name();
}
