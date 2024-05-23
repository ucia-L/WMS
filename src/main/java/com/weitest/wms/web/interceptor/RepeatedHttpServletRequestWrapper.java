package com.weitest.wms.web.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;

import javax.servlet.ReadListener;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;

/**
 * @author sys
 */
public class RepeatedHttpServletRequestWrapper extends javax.servlet.http.HttpServletRequestWrapper {
    private static final Logger LOGGER = LoggerFactory.getLogger(RepeatedHttpServletRequestWrapper.class);
    private byte[] cachedBody;
    public RepeatedHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
        InputStream requestInputStream = request.getInputStream();
        this.cachedBody = StreamUtils.copyToByteArray(requestInputStream);
    }
    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new CachedBodyServletInputStream(this.cachedBody);
    }
    public static class CachedBodyServletInputStream extends ServletInputStream {
        private InputStream cachedBodyInputStream;
        public CachedBodyServletInputStream(byte[] cachedBody) {
            this.cachedBodyInputStream = new ByteArrayInputStream(cachedBody);
        }

        @Override
        public int read() throws IOException {
            return cachedBodyInputStream.read();
        }
        @Override
        public boolean isFinished() {
            try {
                return cachedBodyInputStream.available() == 0;
            } catch (IOException e) {
                LOGGER.error("cachedBodyInputStream error={}",e.getMessage());
            }
            return false;
        }
        @Override
        public boolean isReady() {
            return true;
        }
        @Override
        public void setReadListener(ReadListener readListener) {
            // do nothing
        }

    }
    @Override
    public BufferedReader getReader() throws IOException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(this.cachedBody);
        return new BufferedReader(new InputStreamReader(byteArrayInputStream));
    }
}
