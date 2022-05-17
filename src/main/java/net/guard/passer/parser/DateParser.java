package net.guard.passer.parser;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateParser {
    public static LocalDateTime parseDateTime(String date, String time){
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy HH:mm z");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yy H:mm");
        //ZonedDateTime zonedDateTime = ZonedDateTime.parse(date + " " + time + " " + region, formatter);
        LocalDateTime localDateTime = LocalDateTime.parse(date + " " + time, formatter);
        return localDateTime;
    }
}
