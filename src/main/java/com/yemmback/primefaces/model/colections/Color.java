package com.codenotfound.primefaces.model.colections;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public enum Color {
    Black, White, Green, Red,Blue,Orange,Silver,Yellow,Brown,Maroon,Indigo,Dark_blue,Gold;

    public static String getvalueByindex(int n) {
        return Color.values()[n].name();
    }
    public static int getindexByname(String name) {
        return Color.valueOf(name).ordinal();
    }
    public static String getcolorByname(String name) {
        return Color.valueOf(name).name();
    }
    public static List<String> listColors() {

        List<String> icolors = new ArrayList<String>();
        for (Color color : Color.values()) {
            icolors.add(color.name());
        }
        return icolors;
    }
    public static List<Hashtable> htlistColors() {

        List<Hashtable> icolors = new ArrayList<Hashtable>();
        int i=1;
        for (Color color : Color.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", color);
            icolors.add(cl);
            i+=i;
        }
        return icolors;
    }

}
/*
public enum Color {
    Black("Black"), White("White"), Green("Green"), Red("Red"),
    Blue("Blue"),Orange("Orange"),Silver("Silver"),Yellow("Yellow"),
    Brown("Brown"),Maroon("Maroon"),Indigo("Indigo"),Dark_blue("Dark_blue"),Gold("Gold");


    private final String colorname;

    // Reverse-lookup map for getting a day from an colorname
    private static final Map<String, Color> lookup = new HashMap<String, Color>();

    static {
        for (Color d : Color.values()) {
            lookup.put(d.getAbbreviation(), d);
        }
    }

    private Color(String colorname) {
        this.colorname = colorname;
    }

    public String getAbbreviation() {
        return colorname;
    }

    public static Color get(String colorname) {
        return lookup.get(colorname);
    }
}

 */