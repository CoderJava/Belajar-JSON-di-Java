package com.ysn.belajarjson;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        writeJson();
        System.out.println("====================================");
        readJsonFromFile();
    }

    private static void writeJson() {
        // buat json object root
        JSONObject jsonObjectRoot = new JSONObject();

        // isi nilai nama ke json root
        jsonObjectRoot.put("nama", "Yudi Setiawan");

        // isi nilai hobi ke json root
        JSONArray jsonArrayHobi = new JSONArray();
        jsonArrayHobi.add("menulis");
        jsonArrayHobi.add("membaca");
        jsonArrayHobi.add("bersepeda");
        jsonObjectRoot.put("hobi", jsonArrayHobi);

        // isi nilai usia ke json root
        jsonObjectRoot.put("usia", 23);

        // buat json object orang tua
        JSONObject jsonObjectOrangTua = new JSONObject();

        // buat json object ibu dan isi ke json root
        JSONObject jsonObjectIbu = new JSONObject();
        jsonObjectIbu.put("nama", "Rosmaini");
        jsonObjectRoot.put("ibu", jsonObjectIbu);

        // buat json object ayah dan isi ke json root
        JSONObject jsonObjectAyah = new JSONObject();
        jsonObjectAyah.put("nama", "Mardi");
        jsonObjectRoot.put("ayah", jsonObjectAyah);

        // testing tampilkan nilai yang sudah dimasukkan ke json object root
        System.out.println("jsonObjectRoot: " + jsonObjectRoot.toJSONString());
    }

    private static void readJsonFromFile() {
        JSONParser jsonParser = new JSONParser();
        ClassLoader classLoader = Main.class.getClassLoader();
        try {
            Object object = jsonParser.parse(new FileReader(new File(classLoader.getResource("sample_json_simple.json").getFile())));
            JSONObject jsonObjectRoot = (JSONObject) object;

            // ambil nilai nama
            String nama = (String) jsonObjectRoot.get("nama");

            // ambil nilai hobi
            JSONArray jsonArrayHobi = (JSONArray) jsonObjectRoot.get("hobi");

            // ambil nilai usia
            long usia = (Long) jsonObjectRoot.get("usia");

            // ambil nilai orang tua
            JSONObject jsonObjectOrangTua = (JSONObject) jsonObjectRoot.get("orang_tua");

            // ambil nilai nama ibu
            JSONObject jsonObjectIbu = (JSONObject) jsonObjectOrangTua.get("ibu");
            String namaIbu = (String) jsonObjectIbu.get("nama");

            // ambil nilai nama ayah
            JSONObject jsonObjectAyah = (JSONObject) jsonObjectOrangTua.get("ayah");
            String namaAyah = (String) jsonObjectAyah.get("nama");

            // tampilkan nilai hasil baca json
            System.out.println("nama: \n" + nama + "\n");
            System.out.println("hobi:");
            for (Object objHobi : jsonArrayHobi) {
                String hobi = (String) objHobi;
                System.out.println(hobi);
            }
            System.out.println("\nusia: \n" + usia + "\n");
            System.out.println("nama ibu: \n" + namaIbu + "\n");
            System.out.println("nama ayah: \n" + namaAyah);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}
