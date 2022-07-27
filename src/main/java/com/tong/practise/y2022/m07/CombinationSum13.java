package com.tong.practise.y2022.m07;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class CombinationSum13 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = candidates.length;
        if (len == 0) {
            return result;
        }

        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, target, path, result, len);
        return result;
    }

    private void dfs(int[] candidates, int begin, int target, Deque<Integer> path, List<List<Integer>> result, int len) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            path.addLast(candidates[i]);
            dfs(candidates, begin, target - candidates[i], path, result, len);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSum13 combinationSum = new CombinationSum13();
        int[] candidates = new int[]{2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> res = combinationSum.combinationSum(candidates, target);
        System.out.println("输出 => " + res);
    }


}
