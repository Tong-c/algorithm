package com.tong.practise.y2022.m07;

import java.util.*;

public class CombinationSum22 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(candidates);
        LinkedList<Integer> path = new LinkedList<>();
        dfs(candidates, target, 0, path, result);
        return new ArrayList<>(result);
    }

    private void dfs(int[] candidates, int target, int begin, LinkedList<Integer> path, Set<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = begin; i < candidates.length; i++) {
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.addLast(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, path, result);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSum22 combinationSum = new CombinationSum22();
        int[] candidates = new int[]{10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> res = combinationSum.combinationSum2(candidates, target);
        System.out.println("输出 => " + res);
    }


}
