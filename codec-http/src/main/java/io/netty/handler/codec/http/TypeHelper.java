/*
 * Copyright 2014 Red Hat, Inc.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Apache License v2.0 which accompanies this distribution.
 *
 *  The Eclipse Public License is available at
 *  http://www.eclipse.org/legal/epl-v10.html
 *
 *  The Apache License v2.0 is available at
 *  http://www.opensource.org/licenses/apache2.0.php
 *
 *  You may elect to redistribute this code under either of these licenses.
 */

package io.netty.handler.codec.http;

/**
 * Created by tim on 16/06/15.
 */
public final class TypeHelper {


  private static final Class<?> DEFAULT_HTTP_REQUEST_CLASS = DefaultHttpRequest.class;
  private static final Class<?> DEFAULT_FULL_HTTP_REQUEST_CLASS = DefaultFullHttpRequest.class;

  private static final Class<?> DEFAULT_LAST_HTTP_CONTENT_CLASS = DefaultLastHttpContent.class;
  private static final Class<?> DEFAULT_HTTP_CONTENT_CLASS = DefaultHttpContent.class;
  private static final Class<?> DEFAULT_HTTP_RESPONSE_CLASS = DefaultHttpResponse.class;
  private static final Class<?> DEFAULT_FULL_HTTP_RESPONSE_CLASS = DefaultFullHttpResponse.class;

  public static final boolean isHttpMessage(Object obj) {
    Class<?> clazz = obj.getClass();
    return clazz == DEFAULT_HTTP_REQUEST_CLASS || clazz == DEFAULT_FULL_HTTP_REQUEST_CLASS ||
      clazz == DEFAULT_HTTP_RESPONSE_CLASS || clazz == DEFAULT_FULL_HTTP_RESPONSE_CLASS;
  }

  public static final boolean isHttpRequest(Object obj) {
    Class<?> clazz = obj.getClass();
    return clazz == DEFAULT_HTTP_REQUEST_CLASS || clazz == DEFAULT_FULL_HTTP_REQUEST_CLASS;
  }

  public static final boolean isHttpResponse(Object obj) {
    Class<?> clazz = obj.getClass();
    return clazz == DEFAULT_HTTP_RESPONSE_CLASS || clazz == DEFAULT_FULL_HTTP_RESPONSE_CLASS;
  }

  public static final boolean isHttpContent(Object obj) {
    Class<?> clazz = obj.getClass();
    return clazz == DEFAULT_LAST_HTTP_CONTENT_CLASS || clazz == DEFAULT_HTTP_CONTENT_CLASS ||
      clazz == DEFAULT_FULL_HTTP_RESPONSE_CLASS || clazz == DEFAULT_FULL_HTTP_REQUEST_CLASS;
  }

  public static final boolean isLastHttpContent(Object obj) {
    Class<?> clazz = obj.getClass();
    return clazz == DEFAULT_LAST_HTTP_CONTENT_CLASS ||
      clazz == DEFAULT_FULL_HTTP_RESPONSE_CLASS || clazz == DEFAULT_FULL_HTTP_REQUEST_CLASS;
  }

  public static final boolean isWebsocketFrame(Object obj) {
    Class<?> clazz = obj.getClass();
    return clazz == DEFAULT_LAST_HTTP_CONTENT_CLASS ||
      clazz == DEFAULT_FULL_HTTP_RESPONSE_CLASS || clazz == DEFAULT_FULL_HTTP_REQUEST_CLASS;
  }
}
