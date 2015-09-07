package pl.adalberti.edu.spring.converters;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 * Place description here.
 *
 * @author Q1MW@nykredit.dk
 */

public class JSONObjectMessageConverter extends AbstractHttpMessageConverter<JSONObject> {

    @Override
    protected boolean supports(Class<?> aClass) {
        return aClass.isAssignableFrom(JSONObject.class);
    }

    @Override
    protected JSONObject readInternal(Class<? extends JSONObject> aClass, HttpInputMessage httpInputMessage)
        throws IOException, HttpMessageNotReadableException {
        return new JSONObject();
    }

    @Override
    protected void writeInternal(JSONObject jsonObject, HttpOutputMessage httpOutputMessage)
        throws IOException, HttpMessageNotWritableException {
        httpOutputMessage.getBody().write(jsonObject.toString().getBytes());
    }
}
