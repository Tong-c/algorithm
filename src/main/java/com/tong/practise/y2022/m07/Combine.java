package com.tong.practise.y2022.m07;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        dfs(n, k, 1, path, result);
        return result;

    }

    private void dfs(int n, int k, int begin, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<Integer>(path));
            return;
        }

        for (int i = begin; i <= n; i++) {
            path.addLast(i);
            dfs(n, k, i + 1, path, result);
            path.removeLast();
        }
    }


    public static void main(String[] args) {
        Combine combine = new Combine();
        List<List<Integer>> result = combine.combine(5, 2);
        System.out.println(result);
    }


}
