package com.kerrrusha.transportrental.util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatUtil {

    private static final DecimalFormat decimalFormatter = new DecimalFormat("0.00");
    private static final DecimalFormat decimalFormatterNoDigitsAfterComma = new DecimalFormat("#.##");
    private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm dd.MM.yyyy");

    static {
        decimalFormatter.setRoundingMode(RoundingMode.DOWN);
    }

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(dateTimeFormatter);
    }

    public static String formatPrice(long cents) {
        double dollars = cents / 100.0;
        String result = hasDigitsAfterComma(dollars)
                ? decimalFormatter.format(dollars)
                : decimalFormatterNoDigitsAfterComma.format(dollars);
        return result + " $";
    }

    private static boolean hasDigitsAfterComma(double dollars) {
        return dollars - (long) dollars > 0;
    }

    public static String formatSpeed(long speed) {
        return speed + " km/h";
    }

}
