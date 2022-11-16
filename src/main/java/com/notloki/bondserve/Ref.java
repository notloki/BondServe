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

    public static final String URL = "xxx";

    public static Person getBrian() {
        Person brian = new Person();
        brian.setLang("en");
        brian.setIvrCode("xxxxxx");
        brian.setPhone("xxx");
        brian.setLastName("xxxx");
        return brian;    }
public List<Person> getList() {
        return bondApi.personList();
}



    public static Person getNick() {
        Person nick = new Person();
        nick.setLang("en");
        nick.setIvrCode("xxxxxx");
        nick.setPhone("xxx");
        nick.setLastName("xxxx");
        return nick;
    }



}
