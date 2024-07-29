//package com.zyd.shiro.framework.config;
//
//
//import org.springframework.core.convert.converter.Converter;
//import org.springframework.stereotype.Component;
//
//import java.sql.Time;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.time.LocalTime;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
//@Component
//public class DateConverterConfig2 implements Converter<String, Time> {
//
//
//
//
//
//    @Override
//    public Time convert(String source) {
//        String value = source.trim();
//        if ("".equals(value)) {
//            return null;
//        }
//        if (source.matches("^\\d{1,2}:\\d{1,2}$")) {
//            return parseTime(source);
//        } else {
//            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
//        }
//
//    }
//
//
//
//
//    public Time parseTime(String dateStr) {
//        System.out.println(dateStr);
//        LocalTime parse = LocalTime.parse(dateStr);
//        Time time = Time.valueOf(parse);
//        return time;
//    }
//
//
//
//}
