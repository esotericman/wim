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

package org.flmelody.wim.functions;

import org.flmelody.core.context.support.JsonWindwardContext;
import org.flmelody.wim.annotation.Function;
import org.flmelody.wim.rest.RestResult;

/**
 * @author esotericman
 */
@Function
public class AccountFunction {

  public RestResult<?> login(JsonWindwardContext jsonWindwardContext) {
    return RestResult.success(
        """
                    {
                    "action":"login"

                    }""");
  }

  public RestResult<?> logoff(JsonWindwardContext jsonWindwardContext) {
    return RestResult.success(
        """
                        {
                        "action":"logoff"

                        }""");
  }
}
