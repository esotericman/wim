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

package org.flmelody.wim.message.codec;

import com.google.protobuf.MessageLite;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.flmelody.wim.annotation.Codec;
import org.flmelody.wim.message.codec.spi.ProtobufCodecProviderFactory;

/**
 * @author esotericman
 */
@Codec
public class WimProtobufEncoder extends MessageToByteEncoder<MessageLite> {
  @Override
  protected void encode(ChannelHandlerContext ctx, MessageLite msg, ByteBuf out) throws Exception {
    byte[] body = msg.toByteArray();
    byte[] header = ProtobufCodecProviderFactory.getProvider().encode(msg, (short) body.length);
    out.writeBytes(header);
    out.writeBytes(body);
  }
}
