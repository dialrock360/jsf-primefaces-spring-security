package com.yemmback.primefaces.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum Function {
    directeur, comptable, caissier, magazinier, commercial, gardien;

    public static String getvalueByindex(int n) {
        return Function.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Function.valueOf(name).ordinal();
    }
    public static String getfunctionByname(String name) {
        return Function.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> ifunctions = new ArrayList<String>();
        for (Function function : Function.values()) {
            ifunctions.add(function.name());
        }
        return ifunctions;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> ifunctions = new ArrayList<Hashtable>();
        int i=1;
        for (Function function : Function.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", function);
            ifunctions.add(cl);
            i+=i;
        }
        return ifunctions;
    }

}