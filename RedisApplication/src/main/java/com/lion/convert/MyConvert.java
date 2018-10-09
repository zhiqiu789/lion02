package com.lion.convert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyConvert<S,T> implements Convert<String, Date> {
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Date convert(String source) {
        try {
            return source == null ? null: simpleDateFormat.parse(source);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
