public class sort {
    public static void main(String[] args) {
        int[] nums = {5,4,3,2,1};
        bubbleSort(nums);
        // quickSort(nums, 0, nums.length-1);
        for(int num:nums)
            System.out.printf("%d ", num);
    }
    public static void quickSort(int[] nums, int l,int r){
        if(l>=r)// 递归边界条件
            return ;
        int x = nums[(l+r)/2], i = l-1, j = r+1;// 指针初始值向外扩展一位，适用于do while写法
        do i++; while (nums[i] < x); 
        do j--; while (nums[j] > x); 
        if(i < j){// 出循环的条件：i处的值大于x，j处的值小于x，需要交换
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
        // 递归：注意边界参数
        quickSort(nums, l, j);
        quickSort(nums, j+1, r);
    }
    public static void bubbleSort(int[] nums){
        int len = nums.length;
        for(int i = 0;i<len-1;i++){// 每次把最大的元素浮到上层，需要n-1次
            boolean swapped = false;
            for(int j = 0;j<len-i-1;j++){// 两两交换剩余的元素实现浮动操作
                if (nums[j]>nums[j+1]) {
                    swapped =true;
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
            if (!swapped) {// 若未交换，说明数组已经有序，可提前退出
                break;
            }
        }
    }
    // 归并排序
}
