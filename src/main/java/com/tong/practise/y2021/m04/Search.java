package com.tong.practise.y2021.m04;

public class Search {

    private int counter = 0;

    /**
     * 搜索区间
     *
     * @param nums:   an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[nums.length];
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }
        if (nums.length == 1) {
            if (nums[nums.length - 1] == target) {
                return new int[]{0};
            }
        }
        recSearchRange(result, nums, target, 0, nums.length - 1);

        if (counter > 0) {
            int min = result[0];
            int max = result[0];
            for (int i = 0; i < result.length; i++) {
                int curr = result[i];
                if (i < counter) {
                    if (curr < min) {
                        min = curr;
                    }
                    if (curr > max) {
                        max = curr;
                    }
                }
            }
            return new int[]{min, max};
        } else {
            return new int[]{-1, -1};
        }
    }

    private void recSearchRange(int[] result, int[] nums, int target, int left, int right) {
        if (left + 1 >= right) {
            for (int i = left; i <= right; i++) {
                int curr = nums[i];
                if (curr == target) {
                    System.out.println(curr);
                    result[counter++] = i;
                }
            }
            return;
        }
        int mid = (right + left) / 2;
        int midVal = nums[mid];
        if (midVal == target) {
            result[counter++] = mid;
            System.out.println(midVal);
            recSearchRange(result, nums, target, left, mid - 1);
            recSearchRange(result, nums, target, mid + 1, right);
        }

        if (midVal < target) {
            recSearchRange(result, nums, target, mid + 1, right);
        }

        if (midVal > target) {
            recSearchRange(result, nums, target, left, mid - 1);
        }
    }

    /**
     * 二分查找
     *
     * @param nums   待查找数组
     * @param target 目标值
     * @return 目标值下标
     */
    public int search(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        if (nums[start] == target) {
            return start;
        }

        return -1;
    }


    /**
     * 搜索插入位置
     *
     * @param nums   排序数组
     * @param target 目标值
     * @return 插入的位置
     * @see <a href= "https://leetcode-cn.com/problems/search-insert-position/">35.搜索插入位置</a>
     */
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) {
            return 0;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (start + 1 == end) {
                if (target > nums[start] && target < nums[end]) {
                    return start + 1;
                }
            }
            int mid = (end + start) / 2;
            if (target < nums[mid]) {
                end = mid - 1;
            } else if (target > nums[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }

        if (target < nums[start] && target < nums[0]) {
            return 0;
        }
        if (target == nums[start]) {
            return start;
        }

        if (target < nums[start]) {
            return start - 1;
        }
        return start + 1;
    }


    /**
     * 搜索二维矩阵
     *
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 是否存在
     * @see <a href= "https://leetcode-cn.com/problems/search-a-2d-matrix/">74. 搜索二维矩阵</a>
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (target >= matrix[mid][0] && target <= matrix[mid][matrix[mid].length - 1]) {
                return searchInner(matrix[mid], target);
            } else if (target < matrix[mid][0]) {
                end = mid - 1;
            } else if (target > matrix[mid][matrix[mid].length - 1]) {
                start = mid + 1;
            }
        }

        if (target >= matrix[start][0] && target <= matrix[start][matrix[start].length - 1]) {
            return searchInner(matrix[start], target);
        }
        return false;
    }

    private boolean searchInner(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            int mid = (end + start) / 2;
            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return nums[start] == target;
    }

    /**
     * 第一个错误版本
     *
     * @param n 总版本数量
     * @return 错误的版本号
     * @see <a href= "https://leetcode-cn.com/problems/first-bad-version/">278. 第一个错误的版本</a>
     */
    public int firstBadVersion(int n) {
        int start = 1;
        int end = n;
        int result = -1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (isBadVersion(mid)) {
                if (!isBadVersion(mid - 1)) {
                    return mid - 1;
                }
                if (result != -1) {
                    if (mid < result) {
                        result = mid;
                    }
                } else {
                    result = mid;
                }

                end = mid - 1;
            } else {
                if (isBadVersion(mid + 1)) {
                    return mid + 1;
                }
                start = mid + 1;
            }
        }
        if (isBadVersion(start)) {
            if (result != -1) {
                if (start < result) {
                    result = start;
                }
            } else {
                result = start;
            }

        }
        return result;
    }

    private boolean isBadVersion(int n) {
        return true;
    }

    /**
     * 寻找旋转排序数组中的最小值
     *
     * @param nums 数组
     * @return 数组中的最小值
     * @see <a href= "https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">153. 寻找旋转排序数组中的最小值</a>
     */
    public int findMin(int[] nums) {
        if (nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid - 1;
            } else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }
        }
        return nums[left];
    }


    /**
     * 寻找旋转排序数组中的最小值 2
     *
     * @param nums 数组
     * @return 数组中的最小值
     * @see <a href= "https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/">153. 寻找旋转排序数组中的最小值 2</a>
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] < nums[right]) {
                right = mid;
            } else if (nums[mid] > nums[right]) {
                left = mid;
            } else {
                for (int i = left; i <= mid; i++) {
                    if (nums[i] == nums[mid]) {
                        left = i;
                    } else {
                        break;
                    }
                }

                for (int i = right; i >= mid; i--) {
                    if (nums[i] == nums[mid]) {
                        right = i;
                    } else {
                        break;
                    }
                }
            }
        }
        return nums[left] > nums[right] ? nums[right] : nums[left];
    }


    /**
     * 搜索旋转排序数组
     *
     * @param nums 数组
     * @return 目标值
     * @see <a href= "https://leetcode-cn.com/problems/search-in-rotated-sorted-array/">33. 搜索旋转排序数组</a>
     */
    public int searchRotate(int[] nums, int target) {
        if (nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }


    /**
     * 搜索旋转排序数组 II
     *
     * @param nums 数组
     * @return 目标值
     * @see <a href= "https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/">81. 搜索旋转排序数组 II</a>
     */
    public boolean searchRotate2(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (right + left) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[left] < nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    if (nums[mid] == nums[right]) {
                        if (target > nums[mid] && target < nums[right]) {
                            left = mid + 1;
                        } else {
                            right = mid - 1;
                        }
                    }
                }
            } else if (nums[left] > nums[mid]) {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[mid] == nums[right]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return nums[left] == target;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1};
        Search search = new Search();
        System.out.println(search.searchRotate2(nums, 2));
    }
}
