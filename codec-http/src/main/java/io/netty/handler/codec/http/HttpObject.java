/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.handler.codec.http;

import io.netty.handler.codec.DecoderResult;

public interface HttpObject {
    /**
     * Returns the result of decoding this message.
     */
    DecoderResult getDecoderResult();

    /**
     * Updates the result of decoding this message. This method is supposed to be invoked by {@link HttpObjectDecoder}.
     * Do not call this method unless you know what you are doing.
     */
    void setDecoderResult(DecoderResult result);

  boolean isRequest();

  boolean isResponse();

  boolean isMessage();

  boolean isContent();

  boolean isLast();
}
