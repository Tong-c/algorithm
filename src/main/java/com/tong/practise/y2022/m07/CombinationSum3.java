package com.tong.practise.y2022.m07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
      List<List<Integer>> result = new ArrayList<>();
      LinkedList<Integer> path = new LinkedList<>();
      dfs(n, k, 1, path, result);
      return result;
    }

    private void dfs(int n, int k, int begin, LinkedList<Integer> path, List<List<Integer>> result) {
        if (n < 0) {
            return;
        }

        if (path.size() > k) {
            return;
        }

        if (n == 0 && path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = begin; i < 9; i++) {
            path.addLast(i);
            dfs(n - i, k, i + 1, path, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum3 combinationSum = new CombinationSum3();
        int k = 9;
        int n = 45;
        List<List<Integer>> res = combinationSum.combinationSum3(k, n);
        System.out.println("输出 => " + res);
    }


}
