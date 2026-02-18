package ar.Ziade.personal_finance.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Map;

@RestController
public class PingController {
    @GetMapping("")
    public Map<String,Object>  ping(){
        return Map.of(
                "status","Up",
                "timeStamp", Instant.now().toString()
        );
    }
}
