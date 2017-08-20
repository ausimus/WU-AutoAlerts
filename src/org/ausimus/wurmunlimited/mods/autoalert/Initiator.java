package org.ausimus.wurmunlimited.mods.autoalert;

import com.wurmonline.server.Server;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerPollListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class Initiator  implements WurmServerMod, ServerPollListener, Configurable {
    private Properties prop = new Properties();
    private static boolean transmitTwitter;

    private long lastPoll0 = 0;
    private long Seconds0;

    private long lastPoll01 = 0;
    private long Seconds01;

    private long lastPoll02 = 0;
    private long Seconds02;

    private long lastPoll03 = 0;
    private long Seconds03;

    private long lastPoll04 = 0;
    private long Seconds04;

    private long lastPoll05 = 0;
    private long Seconds05;

    private long lastPoll06 = 0;
    private long Seconds06;

    private long lastPoll07 = 0;
    private long Seconds07;

    private long lastPoll08 = 0;
    private long Seconds08;

    private long lastPoll09 = 0;
    private long Seconds09;

    private boolean useAlert0;
    private boolean useAlert01;
    private boolean useAlert02;
    private boolean useAlert03;
    private boolean useAlert04;
    private boolean useAlert05;
    private boolean useAlert06;
    private boolean useAlert07;
    private boolean useAlert08;
    private boolean useAlert09;



    @Override
    public void configure(Properties properties) {
        transmitTwitter = Boolean.parseBoolean(properties.getProperty("transmitTwitter", Boolean.toString(transmitTwitter)));

        Seconds0 = Long.parseLong(properties.getProperty("Seconds0", Long.toString(Seconds0)));
        useAlert0 = Boolean.parseBoolean(properties.getProperty("useAlert0", Boolean.toString(useAlert0)));

        Seconds01 = Long.parseLong(properties.getProperty("Seconds01", Long.toString(Seconds01)));
        useAlert01 = Boolean.parseBoolean(properties.getProperty("useAlert01", Boolean.toString(useAlert01)));

        Seconds02 = Long.parseLong(properties.getProperty("Seconds02", Long.toString(Seconds02)));
        useAlert02 = Boolean.parseBoolean(properties.getProperty("useAlert02", Boolean.toString(useAlert02)));

        Seconds03 = Long.parseLong(properties.getProperty("Seconds03", Long.toString(Seconds03)));
        useAlert03 = Boolean.parseBoolean(properties.getProperty("useAlert03", Boolean.toString(useAlert03)));

        Seconds04 = Long.parseLong(properties.getProperty("Seconds04", Long.toString(Seconds04)));
        useAlert04 = Boolean.parseBoolean(properties.getProperty("useAlert04", Boolean.toString(useAlert04)));

        Seconds05 = Long.parseLong(properties.getProperty("Seconds05", Long.toString(Seconds05)));
        useAlert05 = Boolean.parseBoolean(properties.getProperty("useAlert05", Boolean.toString(useAlert05)));

        Seconds06 = Long.parseLong(properties.getProperty("Seconds06", Long.toString(Seconds06)));
        useAlert06 = Boolean.parseBoolean(properties.getProperty("useAlert06", Boolean.toString(useAlert06)));

        Seconds07 = Long.parseLong(properties.getProperty("Seconds07", Long.toString(Seconds07)));
        useAlert07 = Boolean.parseBoolean(properties.getProperty("useAlert07", Boolean.toString(useAlert07)));

        Seconds08 = Long.parseLong(properties.getProperty("Seconds08", Long.toString(Seconds08)));
        useAlert08 = Boolean.parseBoolean(properties.getProperty("useAlert08", Boolean.toString(useAlert08)));

        Seconds09 = Long.parseLong(properties.getProperty("Seconds09", Long.toString(Seconds09)));
        useAlert09 = Boolean.parseBoolean(properties.getProperty("useAlert08", Boolean.toString(useAlert09)));
    }

    @Override
    public void onServerPoll() {
        long second = 1000L;
        long sysTime = System.currentTimeMillis();

        if (useAlert0 && System.currentTimeMillis() - second * Seconds0 > lastPoll0) {
            RunAlert0();
            lastPoll0 = sysTime;
        }

        if (useAlert01 && System.currentTimeMillis() - second * Seconds01 > lastPoll01) {
            RunAlert01();
            lastPoll01 = sysTime;
        }

        if (useAlert02 && System.currentTimeMillis() - second * Seconds02 > lastPoll02) {
            RunAlert02();
            lastPoll02 = sysTime;
        }

        if (useAlert03 && System.currentTimeMillis() - second * Seconds03 > lastPoll03) {
            RunAlert03();
            lastPoll03 = sysTime;
        }

        if (useAlert04 && System.currentTimeMillis() - second * Seconds04 > lastPoll04) {
            RunAlert04();
            lastPoll04 = sysTime;
        }

        if (useAlert05 && System.currentTimeMillis() - second * Seconds05 > lastPoll05) {
            RunAlert05();
            lastPoll05 = sysTime;
        }

        if (useAlert06 && System.currentTimeMillis() - second * Seconds06 > lastPoll06) {
            RunAlert06();
            lastPoll06 = sysTime;
        }

        if (useAlert07 && System.currentTimeMillis() - second * Seconds07 > lastPoll07) {
            RunAlert07();
            lastPoll07 = sysTime;
        }

        if (useAlert08 && System.currentTimeMillis() - second * Seconds08 > lastPoll08) {
            RunAlert08();
            lastPoll08 = sysTime;
        }

        if (useAlert09 && System.currentTimeMillis() - second * Seconds09 > lastPoll09) {
            RunAlert09();
            lastPoll09 = sysTime;
        }
    }

    private void RunAlert0() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert0"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert01() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert01"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert02() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert02"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert03() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert03"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert04() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert04"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert05() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert05"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert06() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert06"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert07() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert07"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert08() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert08"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert09() {
        try {
            InputStream input = new FileInputStream("mods/autoalert.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert09"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}