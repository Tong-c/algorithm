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

        if (letters[l] == target) {
            return letters[l + 1];
        }
        if (letters[r] == target) {
            return letters[0];
        }

        return letters[r] > target ? letters[r] : letters[0];
    }

    public static void main(String[] args) {
        NextGreatestLetter_744 tester = new NextGreatestLetter_744();
        char[] letters = {'a', 'd', 'f'};
        char target = 'e';
        System.out.println(tester.nextGreatestLetter(letters, target));
    }
}
