package com.tong.practise.y2022.m07;

import java.util.*;

public class CombinationSum12 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, target, 0, path, result);
        return result;
    }

    private void dfs(int[] candidates, int target, int begin, LinkedList<Integer> path, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, result);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSum12 combinationSum = new CombinationSum12();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }


}
