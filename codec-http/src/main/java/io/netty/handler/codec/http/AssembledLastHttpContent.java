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
import io.netty.buffer.DefaultByteBufHolder;
import io.netty.handler.codec.DecoderResult;

/**
 * Helper wrapper class which allows to assemble a ByteBuf and a HttpHeaders into one "packet" and so more
 * efficient write it through the pipeline.
 *
 * @author <a href="mailto:nmaurer@redhat.com">Norman Maurer</a>
 */
public class AssembledLastHttpContent extends DefaultByteBufHolder implements LastHttpContent {
  private final HttpHeaders trailingHeaders;
  private DecoderResult result;
  public AssembledLastHttpContent(ByteBuf buf, HttpHeaders trailingHeaders, DecoderResult result) {
    super(buf);
    this.trailingHeaders = trailingHeaders;
    this.result = result;
  }

  @Override
  public HttpHeaders trailingHeaders() {
    return trailingHeaders;
  }

  @Override
  public LastHttpContent copy() {
    throw new UnsupportedOperationException();
  }

  @Override
  public LastHttpContent retain(int increment) {
    super.retain(increment);
    return this;
  }

  @Override
  public LastHttpContent retain() {
    super.retain();
    return this;
  }

  @Override
  public HttpContent duplicate() {
    throw new UnsupportedOperationException();
  }

  @Override
  public DecoderResult getDecoderResult() {
    return result;
  }

  @Override
  public void setDecoderResult(DecoderResult result) {
    this.result = result;
  }

  @Override
  public boolean isRequest() {
    return false;
  }

  @Override
  public boolean isResponse() {
    return false;
  }

  @Override
  public boolean isMessage() {
    return false;
  }

  @Override
  public boolean isContent() {
    return true;
  }

  @Override
  public boolean isLast() {
    return true;
  }
}
