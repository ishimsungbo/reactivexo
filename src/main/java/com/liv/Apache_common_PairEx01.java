package com.liv;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.List;

public class Apache_common_PairEx01 {
    public static void main(String[] args) {

        //튜플기능.

        List<Pair<String,Integer>> sales = new ArrayList<>();

        sales.add(Pair.of("A-TV",1000));
        sales.add(Pair.of("B-냉장고",2000));
        sales.add(Pair.of("C-선풍기",3000));

        System.out.println(sales.get(0).getLeft());
        System.out.println(sales.get(0).getRight());

        Pair<String,Integer> pair = Pair.of("가",1);
        pair = Pair.of("나",2);

        Pair<String,Integer> pair02 = Pair.of("다",3);

        System.out.println(pair.getKey());

        // StringUtils.isBlank 초기화 후에 값이 존재하는지 체크
        String str="";

        if(StringUtils.isBlank(str)){
            System.out.println("블랭크 있음");
        }else{
            System.out.println("블랭크 없음");
        }


    }
}
