package com.rakib.jwtsecurity.util;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public final class DateUtil {

    private DateUtil() {
    }

    public static Date getExpiration(Long expireHours) {
        return new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(expireHours));
    }
}
