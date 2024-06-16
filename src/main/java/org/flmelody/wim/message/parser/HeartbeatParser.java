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

package org.flmelody.wim.message.parser;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import lombok.extern.slf4j.Slf4j;
import org.flmelody.core.ws.WebSocketParser;
import org.flmelody.wim.annotation.Parser;
import org.flmelody.wim.message.Heartbeat;
import org.flmelody.wim.message.codec.WimCodecFactory;

/**
 * @author esotericman
 */
@Slf4j
@Parser
@ChannelHandler.Sharable
public class HeartbeatParser extends WebSocketParser<Heartbeat> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Heartbeat msg) throws Exception {
        log.atInfo().log("收到心跳包： " + WimCodecFactory.messageToJson(msg));
    }
}
