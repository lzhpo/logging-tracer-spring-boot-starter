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

package com.lzhpo.logging.trace;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Trace auto configure
 *
 * @author lzhpo
 */
@Configuration
@Conditional({LoggingTraceCondition.class})
@EnableConfigurationProperties({LoggingTraceProperties.class})
public class LoggingTraceAutoConfiguration {

  @Bean
  public LoggingTraceHeaderProxy loggingTraceHeaderProxy(LoggingTraceProperties traceProperties) {
    return new LoggingTraceHeaderProxy(traceProperties);
  }
}
