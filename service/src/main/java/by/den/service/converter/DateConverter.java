package by.den.service.converter;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class DateConverter {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yy hh:mm");

    public static Date toWeb(Date date){
        simpleDateFormat.format(date);
        return date;
    }
}
