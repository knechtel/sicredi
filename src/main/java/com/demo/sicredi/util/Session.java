package com.demo.sicredi.util;

/**
 * Created by maiquelknechtel on 25/10/20.
 */
public class Session {
    private static boolean possivelVotar=false;

    public static boolean isPossivelVotar() {
        return possivelVotar;
    }

    public static void setPossivelVotar(boolean possivelVotar) {
        Session.possivelVotar = possivelVotar;
    }
}
