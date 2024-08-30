package com.qa.utils;

import io.cucumber.java.Scenario;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {
    public static final int IMPLICIT_WAIT_TIME = 20;
    public static final int PAGE_LOAD_TIME = 30;
    public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
    public static final int FLUENT_WAIT_TIME_SECONDS = 30;
    public static final int FLUENT_WAIT_TIME_MILISECOND = 5;
    private static Scenario scene;

    public static String getEmailWithTimeStamp() {

        Date date = new Date();
        return "vivek" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";

    }


    public static String getReportFilenameWithTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_hh_mm_ss_a");
        String timestamp = sdf.format(new Date());
        return timestamp + ".html";

    }
}