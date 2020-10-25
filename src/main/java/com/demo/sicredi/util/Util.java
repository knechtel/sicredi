package com.demo.sicredi.util;

import com.cwi.demo.bean.Pauta;

import java.util.ArrayList;
import java.util.List;

public class Util {

    private static List<Pauta> listPauta =new ArrayList<Pauta>();
    private static boolean vote = false;
    public static boolean isVote() {
        return vote;
    }
    public static void setVote(boolean voÒte) {
        com.cwi.demo.util.Util.vote = vote;
    }

    public static List<Pauta> getListPauta() {
        return listPauta;
    }

    public static void setListPauta(List<Pauta> listPauta) {
        com.cwi.demo.util.Util.listPauta = listPauta;
    }
}
