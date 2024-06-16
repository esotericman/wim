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

import lombok.Data;

/**
 * @author esotericman
 */
@Data
public final class RestResult<T> {
  private Integer code;
  private String msg;
  private T data;

  private RestResult() {}

  private RestResult(Integer code, String msg, T data) {
    this.code = code;
    this.msg = msg;
    this.data = data;
  }

  /**
   * success operation
   *
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> success() {
    return result(ResponseCode.SUCCESS);
  }

  /**
   * success operation
   *
   * @param data data
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> success(T data) {
    return result(ResponseCode.SUCCESS, data);
  }

  /**
   * success operation
   *
   * @param data data
   * @param message message about this operation
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> success(T data, String message) {
    return result(ResponseCode.SUCCESS.getCode(), message, data);
  }

  /**
   * failed operation
   *
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> failed() {
    return result(ResponseCode.FAILED);
  }

  /**
   * failed operation
   *
   * @param message message about this operation
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> failed(String message) {
    return result(ResponseCode.FAILED.getCode(), message);
  }

  /**
   * failed validating
   *
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> validateFailed() {
    return result(ResponseCode.VALIDATE_FAILED);
  }

  /**
   * failed validating
   *
   * @param message message about this operation
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> validateFailed(String message) {
    return result(ResponseCode.VALIDATE_FAILED.getCode(), message);
  }

  /**
   * unauthorized operation
   *
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> unauthorized() {
    return result(ResponseCode.UNAUTHORIZED);
  }

  /**
   * unauthorized operation
   *
   * @param message message about this operation
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> unauthorized(String message) {
    return result(ResponseCode.UNAUTHORIZED.getCode(), message);
  }

  /**
   * forbidden operation
   *
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> forbidden() {
    return result(ResponseCode.FORBIDDEN);
  }

  /**
   * forbidden operation
   *
   * @param message message about this operation
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> forbidden(String message) {
    return result(ResponseCode.FORBIDDEN.getCode(), message);
  }

  /**
   * rest response
   *
   * @param restCode rest code
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> result(RestCode restCode) {
    return result(restCode.getCode(), restCode.getMessage());
  }

  /**
   * rest response
   *
   * @param restCode rest code
   * @param data data
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> result(RestCode restCode, T data) {
    return result(restCode.getCode(), restCode.getMessage(), data);
  }

  /**
   * rest response
   *
   * @param code code of result
   * @param message message about this operation
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> result(Integer code, String message) {
    return result(code, message, null);
  }

  /**
   * rest response
   *
   * @param code code of result
   * @param data data
   * @param message message about this operation
   * @param <T> generic type
   * @return rest result
   */
  public static <T> RestResult<T> result(Integer code, String message, T data) {
    return new RestResult<>(code, message, data);
  }
}
