package com.yemmback.primefaces.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum Nature {
    homme, femme, societe, service, particulier;

    public static String getvalueByindex(int n) {
        return Nature.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Nature.valueOf(name).ordinal();
    }
    public static String getnatureByname(String name) {
        return Nature.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> inatures = new ArrayList<String>();
        for (Nature nature : Nature.values()) {
            inatures.add(nature.name());
        }
        return inatures;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> inatures = new ArrayList<Hashtable>();
        int i=1;
        for (Nature nature : Nature.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", nature);
            inatures.add(cl);
            i+=i;
        }
        return inatures;
    }

}