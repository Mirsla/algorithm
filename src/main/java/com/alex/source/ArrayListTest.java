package com.alex.source;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class ArrayListTest {

    public static void main(String[] args) throws ParseException {
        ArrayList list = new ArrayList();
        list.add(1);
        list.add(2,2);

//            Date date = new Date("2019-08-04");
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        System.out.println(format.parse("2019-08-04"));
//        System.out.println(format.parse("2019-08-12").getTime());
//
//        Calendar cal = Calendar.getInstance();
//        cal.setTime(new Date());
//        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
//        cal.set(Calendar.HOUR_OF_DAY, 0);
//        cal.set(Calendar.MINUTE, 0);
//        cal.set(Calendar.SECOND, 0);
//        cal.set(Calendar.MILLISECOND, 0);
//        System.out.println(cal.getTime().getTime());
//        System.out.println(new Date(1565539200001L).getTime());

        String str = "0_ _ ";
        String regex = "_";
        String[] split = str.split(regex);
        System.out.println(split[0]);
        System.out.println(split[1]);
        System.out.println(split[2]);
        list.forEach(System.out::println);
    }
}
