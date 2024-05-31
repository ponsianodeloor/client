package com.sofka.client.service.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class CommonApplications {
    public int calculateAge(Date birthdate) {
        LocalDate now = LocalDate.now(); // current date
        LocalDate birthdateLocal = birthdate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); // birthdate converted to LocalDate
        return Period.between(birthdateLocal, now).getYears(); // calculate age
    }
}
