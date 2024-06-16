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

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageOrBuilder;
import com.google.protobuf.util.JsonFormat;
import org.flmelody.wim.message.Heartbeat;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author esotericman
 */
public class WimCodecFactory {
  private static final Map<Class<? extends MessageLite>, Short> CLASS_BYTE_MAP = new HashMap<>();

  static {
    // 心跳
    CLASS_BYTE_MAP.put(Heartbeat.class, (short) 0x00);
  }

  public static MessageLite obtainMessageLite(short messageType)
      throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
    for (Class<? extends MessageLite> clazz : CLASS_BYTE_MAP.keySet()) {
      if (CLASS_BYTE_MAP.get(clazz).equals(messageType)) {
        return (MessageLite) clazz.getMethod("getDefaultInstance").invoke(null);
      }
    }
    throw new IllegalAccessException("Unrecognised message type！");
  }

  public static short obtainMessageType(MessageLite messageLite) throws IllegalAccessException {
    for (Class<? extends MessageLite> clazz : CLASS_BYTE_MAP.keySet()) {
      if (messageLite.getClass().isAssignableFrom(clazz)) {
        return CLASS_BYTE_MAP.get(clazz);
      }
    }
    throw new IllegalAccessException("Unrecognised data format！");
  }

  public static String messageToJson(MessageOrBuilder message)
      throws InvalidProtocolBufferException {
    return JsonFormat.printer().print(message);
  }

  public static Message jsonToMessage(String json, Message.Builder builder)
      throws InvalidProtocolBufferException {
    JsonFormat.parser().ignoringUnknownFields().merge(json, builder);
    return builder.build();
  }
}
