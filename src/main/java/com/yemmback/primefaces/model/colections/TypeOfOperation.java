package com.codenotfound.primefaces.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum TypeOfOperation {
    commande, facture, recu,demande,proforma;

    public static String getvalueByindex(int n) {
        return TypeOfOperation.values()[n].name();
    }
    public static int getindexByname(String name) {
        return TypeOfOperation.valueOf(name).ordinal();
    }
    public static String gettypeofoperationByname(String name) {
        return TypeOfOperation.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> itypeofoperations = new ArrayList<String>();
        for (TypeOfOperation typeofoperation : TypeOfOperation.values()) {
            itypeofoperations.add(typeofoperation.name());
        }
        return itypeofoperations;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> itypeofoperations = new ArrayList<Hashtable>();
        int i=1;
        for (TypeOfOperation typeofoperation : TypeOfOperation.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", typeofoperation);
            itypeofoperations.add(cl);
            i+=i;
        }
        return itypeofoperations;
    }

}