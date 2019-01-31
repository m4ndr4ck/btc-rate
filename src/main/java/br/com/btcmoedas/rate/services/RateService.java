package br.com.btcmoedas.rate.services;

import br.com.btcmoedas.rate.model.Rate;
import com.google.gson.*;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
public class RateService {

    public Rate getRate() {
        var cotacao = 99999.0;
        try {
            var url = "https://s3.amazonaws.com/data-production-walltime-info/production/dynamic/walltime-info.json?now=1528962473468.679.0000000000873";
            URL urlObj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();

            // read all the lines of the response into response StringBuffer
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = bufferedReader.readLine()) != null) {
                response.append(inputLine);
            }
            bufferedReader.close();

            // print result in nice format using the Gson library
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            JsonParser jp = new JsonParser();
            JsonElement je = jp.parse(response.toString());
            JsonObject test = je.getAsJsonObject();

            cotacao = jp.parse(response.toString()).getAsJsonObject().get("BRL_XBT").getAsJsonObject().get("last_inexact").getAsDouble();
        }catch (Exception e){
            e.printStackTrace();
        }

        return new Rate().withValue(cotacao+1750);
    }

}
