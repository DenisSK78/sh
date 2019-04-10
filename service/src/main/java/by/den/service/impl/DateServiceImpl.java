package by.den.service.impl;

import by.den.service.converter.DateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class DateServiceImpl {

    @Autowired
    DateConverter dateConverter;

    private Date date;

    public Date getDateNowFromDatabase() {
        date = new Date();
        return date;
    }

    public Date getDateNowFromWeb() {
        this.date = new Date();
        DateConverter.toWeb(date);
        return date;
    }

    public Date getDateFromView(Date date){
        this.date = DateConverter.toWeb(date);
        return date;
    }
}
