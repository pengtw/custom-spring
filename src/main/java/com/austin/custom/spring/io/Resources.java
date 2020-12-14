package com.austin.custom.spring.io;

import java.io.InputStream;

public class Resources {

    /**
     * 加载文件流
     * @param path
     * @return
     */
    public static InputStream getResourceAsStream(String path){
        InputStream inputStream = Resources.class.getClassLoader().getResourceAsStream(path);
        return inputStream;
    }
}
