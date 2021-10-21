package com.notloki.bondserve;

import okhttp3.MediaType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Ref {

@Autowired
 ResultRepository resultRepository;

@Autowired
BondApi<Result> bondApi;

    public static final int UNKNOWN = 2;
    public static final int MUST_TEST = 1;
    public static final int NO_TEST = 0;
public static final boolean debug = true;
public static boolean hasBondsBeenCheckedToday;
public static final MediaType WWW = MediaType.parse(
            "application/x-www-form-urlencoded; charset=utf-8");

    public static final String URL = "https://sentry.cordanths.com/Sentry/WebCheckin/Log";

    public static Person getBrian() {
        Person brian = new Person();
        brian.setLang("en");
        brian.setIvrCode("102874");
        brian.setPhone("8662072911");
        brian.setLastName("Burke+Jr");
        return brian;    }
public List<Person> getList() {
        return bondApi.personList();
}



    public static Person getNick() {
        Person nick = new Person();
        nick.setLang("en");
        nick.setIvrCode("631716");
        nick.setPhone("8662072911");
        nick.setLastName("Hays");
        return nick;
    }



}
