package com.example.myapplication;


import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class ReadJSONFile {
    // Read the company.json file and convert it to a java object.
    public static Thems[] readThemesJSONFile(Context context) throws IOException,JSONException {

        // Read content of physics.json
        String jsonText = readText(context, R.raw.physics);
        JSONArray jsonRoot = new JSONArray(jsonText);
        Thems[] returnValue = new Thems[jsonRoot.length()];

        int i;
        for (i = 0; i < jsonRoot.length(); i++) {
            JSONObject jsonTheme = jsonRoot.getJSONObject(i);
            int id = jsonTheme.getInt("id");
            String name = jsonTheme.getString("name");
            String text = jsonTheme.getString("text");
            JSONArray subThemes = jsonTheme.getJSONArray("themes");
            Thems theme = new Thems();
            theme.setId(id);
            theme.setName(name);
            theme.setText(text);
            theme.setSubThemes(subThemes);
            returnValue[i] = theme;
        }
        return returnValue;
    }

    public static Thems[] parseThemesArray(JSONArray themesArray)  throws JSONException {

        Thems[] returnValue = new Thems[themesArray.length()];

        int i;
        for (i = 0; i < themesArray.length(); i++) {
            JSONObject jsonTheme = themesArray.getJSONObject(i);
            int id = jsonTheme.getInt("id");
            String name = jsonTheme.getString("name");
            String text = jsonTheme.getString("text");
            JSONArray subThemes = jsonTheme.getJSONArray("themes");
            Thems theme = new Thems();
            theme.setId(id);
            theme.setName(name);
            theme.setText(text);
            theme.setSubThemes(subThemes);
            returnValue[i] = theme;
        }
        return returnValue;
    }

    private static String readText(Context context, int resId) throws IOException {
        InputStream is = context.getResources().openRawResource(resId);
        BufferedReader br= new BufferedReader(new InputStreamReader(is));
        StringBuilder sb= new StringBuilder();
        String s= null;
        while((  s = br.readLine())!=null) {
            sb.append(s);
            sb.append("\n");
        }
        return sb.toString();
    }
}


