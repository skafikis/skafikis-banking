package br.com.skafikis.infra.utilities;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JsonHelper {
    public static JsonObject parseJson(String json) {
        return JsonParser.parseString(json).getAsJsonObject();
    }
}
