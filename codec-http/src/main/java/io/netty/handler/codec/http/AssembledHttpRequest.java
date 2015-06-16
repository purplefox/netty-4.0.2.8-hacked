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

import io.netty.buffer.ByteBuf;
import io.netty.handler.codec.DecoderResult;


/**
 * Helper wrapper class which allows to assemble a HttpContent and a HttpRequest into one "packet" and so more
 * efficient write it through the pipeline.
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
public class AssembledHttpRequest implements HttpContent, HttpRequest {
  private final HttpRequest request;
  protected final HttpContent content;

  public AssembledHttpRequest(HttpRequest request, ByteBuf buf) {
    this(request, new DefaultHttpContent(buf));
  }

  public AssembledHttpRequest(HttpRequest request, HttpContent content) {
    this.request = request;
    this.content = content;
  }

  @Override
  public AssembledHttpRequest copy() {
    throw new UnsupportedOperationException();
  }

  @Override
  public AssembledHttpRequest duplicate() {
    throw new UnsupportedOperationException();
  }

  @Override
  public AssembledHttpRequest retain() {
    content.retain();
    return this;
  }

  @Override
  public AssembledHttpRequest retain(int increment) {
    content.retain(increment);
    return this;
  }

  @Override
  public HttpMethod getMethod() {
    return request.getMethod();
  }

  @Override
  public String getUri() {
    return request.getUri();
  }

  @Override
  public HttpHeaders headers() {
    return request.headers();
  }

  @Override
  public HttpRequest setMethod(HttpMethod method) {
    return request.setMethod(method);
  }

  @Override
  public HttpVersion getProtocolVersion() {
    return request.getProtocolVersion();
  }

  @Override
  public HttpRequest setUri(String uri) {
    return request.setUri(uri);
  }

  @Override
  public HttpRequest setProtocolVersion(HttpVersion version) {
    return request.setProtocolVersion(version);
  }

  @Override
  public DecoderResult getDecoderResult() {
    return request.getDecoderResult();
  }

  @Override
  public void setDecoderResult(DecoderResult result) {
    request.setDecoderResult(result);
  }

  @Override
  public ByteBuf content() {
    return content.content();
  }

  @Override
  public int refCnt() {
    return content.refCnt();
  }

  @Override
  public boolean release() {
    return content.release();
  }

  @Override
  public boolean release(int decrement) {
    return content.release(decrement);
  }

  @Override
  public boolean isRequest() {
    return true;
  }

  @Override
  public boolean isResponse() {
    return false;
  }

  @Override
  public boolean isMessage() {
    return true;
  }

  @Override
  public boolean isContent() {
    return true;
  }

  @Override
  public boolean isLast() {
    return false;
  }
}
