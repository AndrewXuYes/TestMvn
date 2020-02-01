package LeeCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class _15_threeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) return res;
        Arrays.sort(nums);

        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if (k > 0 && nums[k] == nums[k - 1]) continue; // 去重

            int i = k + 1, j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum < 0) i++;
                else if (sum > 0) j--;
                else res.add(new ArrayList<>(Arrays.asList(nums[k], nums[i++], nums[j--])));
            }
        }
        //返回前去重
        return res.stream().distinct().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        System.out.println("threeSum==" + threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println("threeSum==" + threeSum(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}));
    }
}
