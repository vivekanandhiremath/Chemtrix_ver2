package com.qa.utils;

import io.cucumber.java.Scenario;

import java.util.Date;

public class CommonUtils {
    private static Scenario scene;
    public static final int IMPLICIT_WAIT_TIME = 20;
    public static final int PAGE_LOAD_TIME = 30;
    public static final int EXPLICIT_WAIT_BASIC_TIME = 30;
    public static final int FLUENT_WAIT_TIME_SECONDS = 30;
    public static final int FLUENT_WAIT_TIME_MILISECOND = 5;

    public static String getEmailWithTimeStamp() {

        Date date = new Date();
        return "vivek" + date.toString().replace(" ", "_").replace(":", "_") + "@gmail.com";

    }
    public static void setScenario(Scenario scene) {
        CommonUtils.scene = scene;
    }
}