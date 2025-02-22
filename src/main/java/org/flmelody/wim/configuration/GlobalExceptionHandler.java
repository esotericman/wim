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

package org.flmelody.wim.configuration;

import org.flmelody.core.ExceptionHandler;
import org.flmelody.core.context.WindwardContext;

/**
 * @author esotericman
 */
public class GlobalExceptionHandler implements ExceptionHandler {
    @Override
    public void handle(WindwardContext windwardContext) {
        windwardContext.writeString("Failed");
    }

    @Override
    public boolean supported(Exception e) {
        return true;
    }
}
