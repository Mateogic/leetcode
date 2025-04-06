public class bindarySearch {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,2,2,2,3,4,5};
        System.out.println(bindarySearchTarget(nums1, 2));
        System.out.println(bindarySearchLeft(nums2, 2));
        System.out.println(bindarySearchRight(nums2, 2));
    }
    // 二分标准模板1:查找单个目标值的精确位置
    // 等值处理:找到目标值立即返回
    // 适用场景:明确得知目标值存在且唯一
    private static int bindarySearchTarget(int[] nums, int target){
        int left = 0, mid = 0, right = nums.length-1;
        while(left <= right){
            mid = left + (right - left)/2;
            if(nums[mid]==target)
                return mid;
            else if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return -1;
    }

    // 二分标准模板2:查找目标值的最左侧位置
    // 等值处理:即便找到目标值，也要继续向左搜索(right = mid - 1)
    // 适用场景
        // 存在重复元素时找第一次出现的位置
        // 查找大于等于目标值的第一个元素
    private static int bindarySearchLeft(int[] nums, int target){
        int left = 0, mid = 0, right = nums.length-1;
        while(left <= right){
            mid = left+(right-left)/2;
            if(nums[mid] < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left < nums.length ? left : -1;
    }

    // 二分标准模板3:查找目标值的最右侧位置
    // 等值处理:即便找到目标值，也要继续向右搜索(left = mid + 1)
    // 适用场景
        // 存在重复元素时找最后一次出现的位置
        // 查找小于等于目标值的最后一个元素
    private static int bindarySearchRight(int[] nums, int target){
        int left = 0, mid = 0, right = nums.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] <= target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return right >= 0 ? right : -1;
    }
}
