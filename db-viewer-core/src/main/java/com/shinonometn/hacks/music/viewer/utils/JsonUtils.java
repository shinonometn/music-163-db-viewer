package com.shinonometn.hacks.music.viewer.utils;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

public class JsonUtils {

    private final static Logger logger = LoggerFactory.getLogger(JsonUtils.class);
    private final static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Read a json object from InputStream.
     * Return null if failed.
     *
     * @param stream InputStream
     * @param <T>    Type
     * @return Instance of this type
     */
    public static <T> T read(InputStream stream) {
        try {
            return objectMapper.readValue(stream, new TypeReference<T>() {
            });
        } catch (IOException e) {
            logger.error("", e);
            return null;
        }
    }

    public static <T> T read(File file){
        try {
            return objectMapper.readValue(file,new TypeReference<T>(){});
        } catch (IOException e) {
            logger.error("", e);
            return null;
        }
    }

    public static <T> T read(InputStream stream, TypeReference<T> typeReference){
        try {
            return objectMapper.readValue(stream,typeReference);
        }catch (IOException e){
            logger.error("",e);
            return null;
        }
    }

    public static String write(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public static void writeToFile(Object object, File file) throws IOException {
        objectMapper.writeValue(file,object);
    }
}
