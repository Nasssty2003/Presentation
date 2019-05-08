package com.example.myapplication;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Thems implements Serializable {
    private String name;
    private int id;
    private String text;
    private JSONArray subThemes;
   private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException, JSONException {
           name = inputStream.readUTF();
           id = inputStream.readInt();
           text = inputStream.readUTF();
           subThemes = new JSONArray((String)inputStream.readObject());

   }
    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        outputStream.writeUTF(name);
        outputStream.writeInt(id);
        outputStream.writeUTF(text);
        outputStream.writeObject(subThemes.toString());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public JSONArray getSubThemes() {
        return subThemes;
    }

    public void setSubThemes(JSONArray subThemes) {
        this.subThemes = subThemes;
    }


}
