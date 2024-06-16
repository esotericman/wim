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

import lombok.RequiredArgsConstructor;
import org.flmelody.core.Windward;
import org.flmelody.core.plugin.PluginSlot;
import org.flmelody.core.plugin.ws.ExtensionalWebSocketPlugin;
import org.flmelody.core.ws.WebSocketParser;
import org.flmelody.core.ws.codec.WebSocketCodec;
import org.flmelody.wim.annotation.Server;
import org.flmelody.wim.authorization.WimAuthorizationProvider;
import org.flmelody.wim.filter.AuthorizationFilter;
import org.flmelody.wim.functions.AccountFunction;
import org.flmelody.wim.functions.SocketFunction;
import org.springframework.beans.factory.ObjectProvider;

import java.util.List;

/**
 * @author esotericman
 */
@Server
@RequiredArgsConstructor
public final class Wim {
  private final WimAuthorizationProvider wimAuthorizationProvider;
  private final ObjectProvider<List<WebSocketCodec>> codecProviders;
  private final ObjectProvider<List<WebSocketParser<?>>> parserProviders;
  private final AccountFunction accountFunction;
  private final SocketFunction socketFunction;

  public void run() {
    ExtensionalWebSocketPlugin extensionalWebSocketPlugin =
        new ExtensionalWebSocketPlugin(
            codecProviders.getIfAvailable(), parserProviders.getIfAvailable());
    Windward.setup()
        .registerFilter(new AuthorizationFilter())
        .registerPlugin(PluginSlot.JSON, new WimJacksonPlugin())
        .registerPlugin(PluginSlot.WEBSOCKET, extensionalWebSocketPlugin)
        .registerExceptionHandler(new GlobalExceptionHandler())
        .group("/account")
        .post("/login", accountFunction::login)
        .post("/logoff", accountFunction::logoff)
        .end()
        .group("/wim")
        .ws("/ws", socketFunction::ws, wimAuthorizationProvider)
        .end()
        .run();
  }
}
