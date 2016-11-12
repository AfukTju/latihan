package com.example.generator;


import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

/**
 * Created by AfukTju on 12/11/2016.
 */

public class Generator {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.example.afuktju.solutionapp.greendao.model");
        generateDtbPost(schema);
        try {
            new DaoGenerator().generateAll(schema, "app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void generateDtbPost(Schema schema) {
        Entity dtb_user_type = schema.addEntity("DtbPost");
        dtb_user_type.addLongProperty("id").primaryKey();
        dtb_user_type.addLongProperty("userId");
        dtb_user_type.addStringProperty("title");
        dtb_user_type.addStringProperty("body");
    }
}
