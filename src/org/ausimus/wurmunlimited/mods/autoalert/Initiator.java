package org.ausimus.wurmunlimited.mods.autoalert;

import com.wurmonline.server.Players;
import com.wurmonline.server.Server;
import com.wurmonline.server.Servers;
import com.wurmonline.server.villages.Village;
import com.wurmonline.server.villages.Villages;
import org.gotti.wurmunlimited.modloader.interfaces.Configurable;
import org.gotti.wurmunlimited.modloader.interfaces.ServerPollListener;
import org.gotti.wurmunlimited.modloader.interfaces.WurmServerMod;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Initiator  implements WurmServerMod, ServerPollListener, Configurable {
    private Properties prop = new Properties();

    private long sysTime = System.currentTimeMillis();

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

    private boolean useDeedAlert;
    private long DA_lastPoll = 0;
    private long DA_pollSeconds;
    private int MaxDays;
    private boolean autoDisband;


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

        useDeedAlert = Boolean.parseBoolean(properties.getProperty("useDeedAlert", Boolean.toString(useDeedAlert)));
        DA_pollSeconds = Long.parseLong(properties.getProperty("DA_pollSeconds", Long.toString(DA_pollSeconds)));
        MaxDays = Integer.parseInt(properties.getProperty("MaxDays", Integer.toString(MaxDays)));
        autoDisband = Boolean.parseBoolean(properties.getProperty("autoDisband", Boolean.toString(autoDisband)));
    }

    @Override
    public void onServerPoll() {
        long second = 1000L;

        if (useAlert0 && sysTime - second * Seconds0 > lastPoll0) {
            RunAlert0();
            lastPoll0 = sysTime;
        }

        if (useAlert01 && sysTime - second * Seconds01 > lastPoll01) {
            RunAlert01();
            lastPoll01 = sysTime;
        }

        if (useAlert02 && sysTime - second * Seconds02 > lastPoll02) {
            RunAlert02();
            lastPoll02 = sysTime;
        }

        if (useAlert03 && sysTime - second * Seconds03 > lastPoll03) {
            RunAlert03();
            lastPoll03 = sysTime;
        }

        if (useAlert04 && sysTime - second * Seconds04 > lastPoll04) {
            RunAlert04();
            lastPoll04 = sysTime;
        }

        if (useAlert05 && sysTime - second * Seconds05 > lastPoll05) {
            RunAlert05();
            lastPoll05 = sysTime;
        }

        if (useAlert06 && sysTime - second * Seconds06 > lastPoll06) {
            RunAlert06();
            lastPoll06 = sysTime;
        }

        if (useAlert07 && sysTime - second * Seconds07 > lastPoll07) {
            RunAlert07();
            lastPoll07 = sysTime;
        }

        if (useAlert08 && sysTime - second * Seconds08 > lastPoll08) {
            RunAlert08();
            lastPoll08 = sysTime;
        }

        if (useAlert09 && sysTime - second * Seconds09 > lastPoll09) {
            RunAlert09();
            lastPoll09 = sysTime;
        }

        if (useDeedAlert && sysTime - second * DA_pollSeconds > DA_lastPoll) {
            RunDeedAlert();
            DA_lastPoll = sysTime;
        }

    }

    private void RunDeedAlert() {
        Village[] villages = Villages.getVillages();
        // noinspection ForLoopReplaceableByForEach
        for (int index = 0; index < villages.length; ++index) {
            if (villages[index] != null) {
                long lastLogout = Players.getInstance().getLastLogoutForPlayer(villages[index].getMayor().getId());
                long deltaDay = System.currentTimeMillis() - lastLogout;
                long days = TimeUnit.MILLISECONDS.toDays(deltaDay);
                if (!villages[index].isPermanent && days >= MaxDays) {
                    WriteLog(villages[index].getName() + " mayor " + villages[index].getMayor().getName() + " has not logged in for " + days + " days.");
                    Server.getInstance().broadCastAlert(villages[index].getName() + " mayor " + villages[index].getMayor().getName() + " has not logged in for " + days + " days.", transmitTwitter);
                    if (autoDisband) {
                        WriteLog(villages[index].getName() + " Disbanded by " + Servers.getLocalServerName() + " (Mayor NoLogin). " + " Mayor Name = " + villages[index].getMayor().getName() + ".");
                        villages[index].disband(Servers.getLocalServerName() + " (Mayor NoLogin)");
                    }
                }
            }
        }
    }

    private void RunAlert0() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert0"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert01() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert01"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert02() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert02"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert03() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert03"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert04() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert04"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert05() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert05"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert06() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert06"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert07() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert07"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert08() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert08"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void RunAlert09() {
        try {
            InputStream input = new FileInputStream("mods/AutoAlerts.properties");
            prop.load(input);
            Server.getInstance().broadCastAlert(prop.getProperty("Alert09"), transmitTwitter);
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    private void WriteLog(String data) {
        try {
            String logFile = "mods/AutoAlerts/log.txt";
            FileWriter writeLog = new FileWriter(logFile, true);
            BufferedWriter bufferedLogWriter = new BufferedWriter(writeLog);
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss ");
            Date timeStamp = new Date();
            bufferedLogWriter.write(dateFormat.format(timeStamp) + data + "\n");
            bufferedLogWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}