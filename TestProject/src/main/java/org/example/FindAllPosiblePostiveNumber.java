package org.example;

import java.util.ArrayList;
import java.util.List;

public class FindAllPosiblePostiveNumber {

    public static List<List<Integer>> rec(int n){
        List<List<Integer>> res=new ArrayList<>();
        if(n==0) return res;

        for(int i=1;i<=n;i++){
            List<Integer> cur=new ArrayList<>();
            cur.add(i);
            if(n==i){
                res.add(cur);
            }else{
                List< List<Integer>> returnedArray=rec(n-i);
                for(List<Integer> it:returnedArray){
                    cur=new ArrayList<>();
                    cur.add(i);
                    cur.addAll(it);
                    res.add(copyArray(cur));
                }

            }


        }
        return  res;
    }

    private static List<Integer> copyArray(List<Integer> cur) {
        List<Integer> res=new ArrayList<>();
        for(int i:cur){
            res.add(i);
        }
        return res;
    }
}

