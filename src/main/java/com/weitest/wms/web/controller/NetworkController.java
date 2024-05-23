package com.weitest.wms.web.controller;

import com.weitest.wms.util.NetWorkUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Network related
 *
 * @author ifcc
 */
@RestController
public class NetworkController {
    @GetMapping("/api/system/getCurrentIp")
    public String getCurrentIp(HttpServletRequest request) {
        return NetWorkUtils.getCurrentIp(request);
    }
}