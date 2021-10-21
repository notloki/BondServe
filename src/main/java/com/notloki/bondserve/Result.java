package com.notloki.bondserve;

import com.google.gson.Gson;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@Entity
public class Result implements Entity {

    private @Id @GeneratedValue Long id;
    private String text;
    private int required_test;
    private String transaction_key;
    private String date;
    private String localDate;

    Result() {}

    public Result(String text, int required_test,
                        String transaction_key, String date) {

        this.text = text;
        this.required_test = required_test;
        this.transaction_key = transaction_key;
        this.date = date;
        this.localDate = new SimpleDateFormat("mmDDyyyy")
                .format(Calendar
                        .getInstance()
                        .getTimeInMillis());
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public String getLocalDate() {
        return localDate;
    }
    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRequired_test() {
        return required_test;
    }

    public void setRequired_test(int required_test) {
        this.required_test = required_test;
    }

    public String getTransaction_key() {
        return transaction_key;
    }

    public void setTransaction_key(String transaction_key) {
        this.transaction_key = transaction_key;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


    @Override
    public boolean equals(Object o) {

        if (this == o)
            return true;
        if (!(o instanceof Result))
            return false;
        Result result = (Result) o;
        return Objects.equals(this.id, result.id) &&
                Objects.equals(this.text, result.text) &&
                Objects.equals(this.date, result.date) &&
                Objects.equals(this.transaction_key, result.transaction_key) &&
                Objects.equals(this.required_test, result.required_test) &&
                Objects.equals(this.localDate, result.localDate);
    }

    public String toPrettyString() {
        return this.text;
        }


    @Override
    public String toString() {

        return "\n" +  "Id: " +this.id + "\n" +
                       "Text: " + this.text + "\n" +
                       "Date: " + this.date + "\n" +
                       "Transaction Key: " + this.transaction_key + "\n" +
                       "Required Test: " + this.required_test;

    }

    public Result toObj(String json) {
        Gson gson = new Gson();
        json = json.replace("[", "").replace("]", "");
        return gson.fromJson(json, Result.class);
    }
    public String toJson(Result result) {
        Gson gson = new Gson();
        return gson.toJson(result, Result.class);
    }

}
