package com.drd.jmsclient;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by drd on 15/09/15
 */
public class FileToBytes {

    public byte[] getBytes() throws IOException {
        InputStream resourceAsStream = null;
        byte[] bytes;
        try {
            resourceAsStream = getClass().getClassLoader().getResourceAsStream("smallfile.pdf");
            bytes = IOUtils.toByteArray(resourceAsStream);
        } finally {
            IOUtils.closeQuietly(resourceAsStream);
        }
        return bytes;
    }
}
