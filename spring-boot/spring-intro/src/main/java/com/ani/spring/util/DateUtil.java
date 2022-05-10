package com.ani.spring.util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DateUtil {

    private String profile = "default";

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public long diffFromToday(LocalDate date) {
        return date.until(LocalDate.now(), ChronoUnit.DAYS);
    }
}
