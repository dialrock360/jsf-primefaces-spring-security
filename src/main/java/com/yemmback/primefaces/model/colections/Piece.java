package com.codenotfound.primefaces.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public enum Piece {
    cni, passeport, professionallcard, ninea, rc;

    public static String getvalueByindex(int n) {
        return Piece.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Piece.valueOf(name).ordinal();
    }
    public static String getpieceByname(String name) {
        return Piece.valueOf(name).name();
    }
    public static List<String> listRoles() {

        List<String> ipieces = new ArrayList<String>();
        for (Piece piece : Piece.values()) {
            ipieces.add(piece.name());
        }
        return ipieces;
    }
    public static List<Hashtable> htlistRoles() {

        List<Hashtable> ipieces = new ArrayList<Hashtable>();
        int i=1;
        for (Piece piece : Piece.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", piece);
            ipieces.add(cl);
            i+=i;
        }
        return ipieces;
    }

}