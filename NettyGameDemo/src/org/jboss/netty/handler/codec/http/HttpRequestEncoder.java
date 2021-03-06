/*
 * Copyright 2009 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package org.jboss.netty.handler.codec.http;

import static org.jboss.netty.handler.codec.http.HttpCodecUtil.CR;
import static org.jboss.netty.handler.codec.http.HttpCodecUtil.LF;
import static org.jboss.netty.handler.codec.http.HttpCodecUtil.SP;

import org.jboss.netty.buffer.ChannelBuffer;

/**
 * Encodes an {@link HttpRequest} or an {@link HttpChunk} into
 * a {@link ChannelBuffer}.
 *
 * @author <a href="http://www.jboss.org/netty/">The Netty Project</a>
 * @author Andy Taylor (andy.taylor@jboss.org)
 * @author <a href="http://gleamynode.net/">Trustin Lee</a>
 * @version $Rev: 2118 $, $Date: 2010-02-01 17:32:18 +0900 (Mon, 01 Feb 2010) $
 */
public class HttpRequestEncoder extends HttpMessageEncoder {

    /**
     * Creates a new instance.
     */
    public HttpRequestEncoder() {
        super();
    }

    @Override
    protected void encodeInitialLine(ChannelBuffer buf, HttpMessage message) throws Exception {
        HttpRequest request = (HttpRequest) message;
        buf.writeBytes(request.getMethod().toString().getBytes("ASCII"));
        buf.writeByte(SP);
        buf.writeBytes(request.getUri().getBytes("ASCII"));
        buf.writeByte(SP);
        buf.writeBytes(request.getProtocolVersion().toString().getBytes("ASCII"));
        buf.writeByte(CR);
        buf.writeByte(LF);
    }
}
