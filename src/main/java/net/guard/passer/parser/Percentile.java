package net.guard.passer.parser;

import java.util.List;

public class Percentile {
    public static void fundingValue(double percentile, List<Integer> list){
        int rank = (int) Math.ceil(percentile/100*list.size());
        System.out.println(percentile + "-ый процентиль: " + list.get(rank-1) + " мин");
    }
}
