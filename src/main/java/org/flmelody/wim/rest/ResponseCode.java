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

package org.flmelody.wim.rest;

import lombok.Getter;

/**
 * @author esotericman
 */
@Getter
public enum ResponseCode implements RestCode {
  SUCCESS(200, "操作成功"),
  VALIDATE_FAILED(400, "参数校验失败"),
  UNAUTHORIZED(401, "暂未登录或令牌已经过期"),
  FORBIDDEN(403, "没有相关权限"),
  NOT_FOUND(404, "资源不存在"),
  FAILED(500, "操作失败");

  ResponseCode(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  private final Integer code;
  private final String message;

  @Override
  public Integer getCode() {
    return code;
  }

  @Override
  public String getMessage() {
    return message;
  }
}
