package com.database;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class main {
    public static void main(String[] args) {
        final char dm = (char) 34;

        StringBuilder builder = new StringBuilder();
        builder.append("[{");
        builder.append(dm);
        builder.append("tag");
        builder.append(dm);
        builder.append(":");
        builder.append(dm);
        builder.append("кек");
        builder.append(dm);
        builder.append("}, {");
        builder.append(dm);
        builder.append("tag");
        builder.append(dm);
        builder.append(":");
        builder.append(dm);
        builder.append("лол");
        builder.append(dm);
        builder.append("}]");

//        builder.append("{");
//        builder.append(dm);
//        builder.append("кек");
//        builder.append(dm);
//        builder.append(", ");
//        builder.append(dm);
//        builder.append("лол");
//        builder.append(dm);
//        builder.append("}");

//        Gson gson = new Gson()
//        ArrayList<SupplyPrice> suplyPrices = gson.fromJson(pJsonString, SupplyPrice.class);
//
//        String jsonString = builder.toString();
//        JsonParser parser = new JsonParser();
//        JsonObject jsonObject = parser.parse(jsonString).getAsJsonObject();
//        JsonArray jsonArray = jsonObject.getAsJsonArray("tag");
//
//        System.out.println(jsonArray);


       // {"someInt":"123","someString":"value1"}

        JSONArray jsonArray = new JSONArray(builder.toString());

        for(int i=0; i<jsonArray.length(); i++){
        try {
            JSONObject json =(JSONObject) (jsonArray.get(i));
            String someString = json.getString("tag");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }}
}
