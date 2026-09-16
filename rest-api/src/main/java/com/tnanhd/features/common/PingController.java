package com.tnanhd.features.common;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

  @GetMapping(ApiResources.PING)
  public String ping() {
    return "Welcome to Kanjiya service";
  }
}
