package com.demo.sicredi.util;

import com.demo.sicredi.domain.Pauta;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by maiquelknechtel on 25/10/20.
 */
public class Util {

    private static List<Pauta> listPauta =new ArrayList<Pauta>();
    private static boolean vote = false;
    public static boolean isVote() {
        return vote;
    }
    public static void setVote(boolean voÒte) {
        vote = vote;
    }

    public static List<Pauta> getListPauta() {
        return listPauta;
    }

    public static void setListPauta(List<Pauta> listPauta) {
        listPauta = listPauta;
    }
}
