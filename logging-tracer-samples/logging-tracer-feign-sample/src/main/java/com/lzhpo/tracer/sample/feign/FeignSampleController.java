/*
 * Copyright 2022 lzhpo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.lzhpo.tracer.sample.feign;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzhpo
 */
@Slf4j
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class FeignSampleController {

  private final ServiceSampleClient serviceSampleClient;

  @GetMapping("/hello")
  public String hello(HttpServletRequest request) {
    log.info("Received new request for hello api.");

    Enumeration<String> headerNames = request.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String headerName = headerNames.nextElement();
      log.info("Request header with [{}: {}]", headerName, request.getHeader(headerName));
    }

    return serviceSampleClient.hello();
  }
}
