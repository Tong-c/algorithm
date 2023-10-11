package com.tong.practise.y2023.binarysearch;

public class NextGreatestLetter_744 {

    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int r = letters.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (letters[mid] == target) {
                return letters[mid + 1];
            } else if (letters[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        if (l < letters.length - 1) {
            return letters[l + 1];
        } else {
            return letters[l] > target ? letters[l] : letters[0];
        }

    }

    public static void main(String[] args) {
        NextGreatestLetter_744 tester = new NextGreatestLetter_744();
        char[] letters = {'c', 'f', 'g'};
        char target = 'd';
        System.out.println(tester.nextGreatestLetter(letters, target));
    }
}
