package com.notloki.bondserve;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import static com.notloki.bondserve.Ref.URL;
import static com.notloki.bondserve.Ref.WWW;
// TODO: Purpose: BondCheck

public class BondCheck {

    private static final Logger log = LoggerFactory.getLogger(BondCheck.class);

    @Autowired
        BondApi bondApi;

    BondCheck() {}

    OkHttpClient client = new OkHttpClient();

    Result post(String urlEncoded) throws IOException {
        log.info("Starting BondCheck.post()");


        RequestBody body = RequestBody.create(WWW, urlEncoded);
        String responseBody = "Error: ResponseBody is Null";
        log.info("Building request");
        Request request = new Request.Builder()
                .url(URL)
                .addHeader("authority", "sentry.cordanths.com")
                .addHeader("accept", "application/json, text/javascript, */*; q=0.01")
                .addHeader("user-agent", "Mozilla/5.0 (Linux; Android 6.0; Nexus 5 Build/MRA58N) " +
                        "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.111 Mobile Safari/537.36")
                .addHeader("content-type", "application/x-www-form-urlencoded; charset=UTF-8")
                .addHeader("Origin", "https://www.mycallin.com")
                .addHeader("sec-fetch-site", "cross-site")
                .addHeader("sec-fetch-mode", "cors")
                .addHeader("sec-fetch-dest", "empty")
                .addHeader("referer", "https://www.mycallin.com/")
                .addHeader("accept-language", "en-US,en;q=0.9")
                .post(body)
                .build();
        log.info("Request Sent");
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                responseBody = response.body().string();
                log.info("Response Successful" + "\n" + responseBody);
            } else {
                log.error("Response Unsuccessful" + response.networkResponse());
            }

            log.debug(responseBody);
        }

        return new Result().toObj(responseBody);

    }

    String urlEncode(String phone, String lastName,
                     String ivrCode, String lang) {
        return ("phone=" + phone + "&"
                + "last_name=" + lastName + "&"
                + "ivr_code=" + ivrCode + "&"
                + "lang=" + lang);

    }

    String urlEncodeObj(Person person) {
        return("phone=" + person.getPhone() + "&" +
               "last_name=" + person.getLastName() + "&" +
               "ivr_code=" + person.getIvrCode() + "&" +
                "lang=" + person.getLang());

    }


    public Result checkBond(Person person) throws IOException {
    return post(urlEncodeObj(person));
 }
}


