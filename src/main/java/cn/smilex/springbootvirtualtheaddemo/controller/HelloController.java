package cn.smilex.springbootvirtualtheaddemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author smilex
 * @date 2022/11/18/12:39
 * @since 1.0
 */
@Slf4j
@RestController
public class HelloController {

    @GetMapping("/")
    public String hello() {
        log.info("{}", Thread.currentThread());
        return "";
    }
}
