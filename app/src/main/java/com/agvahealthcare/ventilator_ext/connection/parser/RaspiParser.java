package com.agvahealthcare.ventilator_ext.connection.parser;

import android.util.Log;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by MOHIT MALHOTRA on 13-09-2018.
 */

public class RaspiParser extends ParserUtils {
    public static final String TYPE_INHALATION = "A";
    public static final String TYPE_END_OF_INHALATION = "B";
    public static final String DATA_PRESSURE = "DATA_PRESSURE";
    public static final String DATA_FLOW = "DATA_FLOW";
    public static final String DATA_FLOW_VALUE = "DATA_FLOW_VALUE";
    public static final String DATA_PAW = "DATA_PAW";
    public static final String DATA_FIO2 = "DATA_FIO2";
    public static final String DATA_N2O = "DATA_N2O";
    public static final String DATA_O2 = "DATA_O2";

    private Map<String, Map<String, String>> dataMap;
    {
        dataMap = new LinkedHashMap<>();
        dataMap.put(TYPE_INHALATION, getConfigMap(DATA_FLOW, DATA_PRESSURE,"0","0"));
        dataMap.put(TYPE_END_OF_INHALATION, getConfigMap(DATA_FLOW_VALUE, DATA_PAW, DATA_FIO2, DATA_O2,"0","0","0","0","0","0","0"));
    }

    public RaspiParser addExtension(Class<? extends ParserExtension> extClass){
        if(dataMap != null){
            try {
                ParserExtension ext = extClass.newInstance();
                dataMap.putAll(ext.getDataMap());
                Log.i("PARSE_EXT", "Extension added successfully");
            } catch (IllegalAccessException | InstantiationException e) {
                e.printStackTrace();
            }
        }

        return this;
    }

    public final String getDataType(String msg){
        String type=msg.substring(0,msg.indexOf("@"));
        return type;
    }

    public final Map<String, Map<String, String>> parser(String msg){

        if(!msg.contains("@")){
            Log.i("PARSER EXCEPTION", "Type not defined");
            return null;
        }

        if(!msg.contains(",")){
            Log.i("PARSER EXCEPTION", "No data present");
            return null;
        }

        if(!msg.contains("#")){
            Log.i("PARSER EXCEPTION", "Delimiter not found");
            return null;
        }

        String type = msg.substring(0, msg.indexOf("@"));
        String rawData = msg.substring(msg.indexOf("@") + 1, msg.indexOf("#"));

        String[] data = rawData.split(",");

        Map<String, String> selectedMap = dataMap.get(type);

        // NPE safety check return
        if(selectedMap == null) return null;

        Iterator<String> iterator = selectedMap.keySet().iterator();
        for(String datum : data){
            if(iterator.hasNext()){
                selectedMap.put(iterator.next(), datum);
            }
        }
        Map<String, Map<String, String>> retMap = new LinkedHashMap<>();
        retMap.put(type, selectedMap);

        return retMap;
    }
}

