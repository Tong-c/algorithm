package com.tong.practise.y2022.m07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        int len = candidates.length;
        if (len == 0) {
            return result;
        }

        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, 0, target, path, result, candidates.length);

        return result;
    }

    private void dfs(int[] candidates, int begin, int target, LinkedList<Integer> path, List<List<Integer>> result, int len) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = begin; i < len; i++) {
            if (target - candidates[i] < 0) {
                break;
            }

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, i + 1, target - candidates[i], path, result, len);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        CombinationSum2 combinationSum = new CombinationSum2();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }


}
