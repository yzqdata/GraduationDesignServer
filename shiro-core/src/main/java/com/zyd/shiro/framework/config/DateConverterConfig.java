package com.zyd.shiro.framework.config;


import lombok.SneakyThrows;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DateConverterConfig implements Converter<String, Date> {

    private static final List<String> formarts = new ArrayList<>(10);
    static{
        formarts.add("yyyy-MM");
        formarts.add("yyyy-MM-dd");
        formarts.add("yyyy-MM-dd hh:mm");
        formarts.add("yyyy-MM-dd HH:mm:ss");
    }



    @SneakyThrows
    @Override
    public Date convert(String source) {
        String value = source.trim();
        if ("".equals(value)) {
            return null;
        }
        String regex = "(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{1,2}:\\d{2} [APMapm]{2})";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(source);

        String regex2 = "(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[+-]\\d{4})";
        Pattern pattern2 = Pattern.compile(regex2);
        Matcher matcher2 = pattern2.matcher(source);

        Date dateTime= null;
        if (matcher.matches()) {
            String datePart = matcher.group(1);
            String timePart = matcher.group(2);
            String dateTimeString = datePart + " " + timePart;
            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a", Locale.ENGLISH);
            try {
                 dateTime = dateFormat.parse(dateTimeString);
            } catch (ParseException e) {
                e.printStackTrace();
            }
       }else if (matcher2.find()) {
            String datePart =  matcher2.group(1);
            datePart = datePart.replace("+0000", "GMT");
            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            dateTime = inputFormat.parse(datePart);
        }
        else {
            throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
        }
        return dateTime;
    }


    /**
     * 格式化日期
     * @param dateStr String 字符型日期
     * @param format String 格式
     * @return Date 日期
     */
    public Date parseDate(String dateStr, String format) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a", Locale.ENGLISH);
        Date date=null;
        try {
            date = dateFormat.parse(dateStr);
        } catch (Exception e) {

        }
        return date;
    }


    public static void main(String[] args) {
        String input = "2023-11-20T10:00:00.000+0000";


        Date convert = new DateConverterConfig().convert(input);
        System.out.println(convert);
//        System.out.println(convert);
//        String regex = "(\\d{1,2}/\\d{1,2}/\\d{4}) (\\d{1,2}:\\d{2} [APMapm]{2})";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//        if (matcher.matches()) {
//            String datePart = matcher.group(1);
//            String timePart = matcher.group(2);
//
//            System.out.println("Date: " + datePart);
//            System.out.println("Time: " + timePart);
//
//            String dateTimeString = datePart + " " + timePart;
//
//            SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm a", Locale.ENGLISH);
//            try {
//                Date dateTime = dateFormat.parse(dateTimeString);
//                // 使用 SimpleDateFormat 将 Date 对象格式化为字符串
//                SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String formattedDateTime = outputFormat.format(dateTime);
//
//                // 输出格式化后的时间字符串
//                System.out.println("Formatted Date: " + formattedDateTime);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//        } else {
//            System.out.println("No match found.");
//        }

    }

//    public static void main(String[] args) {
//        String input = "2023-11-20T10:00:00.000+0000";
//        String regex = "(\\d{4}-\\d{2}-\\d{2}T\\d{2}:\\d{2}:\\d{2}\\.\\d{3}[+-]\\d{4})";
//
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(input);
//
//        if (matcher.find()) {
//            String dateTimeString = matcher.group(1);
//
//            // 替换掉字符串中的"+0000"为"GMT"，因为SimpleDateFormat无法直接解析"+0000"这样的时区表示
//            dateTimeString = dateTimeString.replace("+0000", "GMT");
//
//            SimpleDateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
//            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//
//            try {
//                Date date = inputFormat.parse(dateTimeString);
//                String formattedDate = outputFormat.format(date);
//
//                System.out.println("Formatted Date: " + formattedDate);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        } else {
//            System.out.println("No match found.");
//        }
//    }

}
