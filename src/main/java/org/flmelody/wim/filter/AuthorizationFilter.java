/*
 * Copyright (C) 2023 Flmelody.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.flmelody.wim.filter;

import org.flmelody.core.Filter;
import org.flmelody.core.HttpHeader;
import org.flmelody.core.WindwardRequest;
import org.flmelody.core.context.WindwardContext;
import org.flmelody.core.exception.WindwardException;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author esotericman
 */
public class AuthorizationFilter implements Filter {
  @Override
  public void filter(WindwardContext windwardContext) {
    WindwardRequest windwardRequest = windwardContext.windwardRequest();

    Optional<String> first =
        windwardRequest.getHeader(HttpHeader.AUTHORIZATION).stream().findFirst();
    if (first.isPresent()) {
      String token = first.get();
      String method = windwardRequest.getMethod();
      Map<String, List<String>> querystring = windwardRequest.getQuerystring();
    }
    throw new WindwardException("无权访问");
  }
}
