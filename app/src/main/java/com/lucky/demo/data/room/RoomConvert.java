package com.lucky.demo.data.room;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class RoomConvert {
    @TypeConverter
    public List<Map<String,String>> string2ListMap(String value) {
        Type type = new TypeToken<List<Map<String,String>>>() {}.getType();
        return new Gson().fromJson(value, type);
    }
    @TypeConverter
    public static String listMap2String(List<Map<String,String>> data) {
        Gson gson = new Gson();
        String json = gson.toJson(data);
        return json;
    }
}
