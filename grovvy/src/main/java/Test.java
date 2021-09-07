import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        int[] s=new int[]{2,3,2};
        new Solution().rob(s);
    }
    public int rob(int[] nums) {
        int money=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>money){
                money=nums[i];
            }
        }
        if(nums.length==0){
            return 0;
        }
        List<Integer> list1=new ArrayList<Integer>();
        List<Integer> list2=new ArrayList<Integer>();



        int a=sum(list1);
        int b=sum(list2);


        return a>b?a:b;
    }


    public int sum(List<Integer> sum){
        int money = 0;
        for(int i=0;i<sum.size();i++){
            money+=sum.get(i);
        }
        return money;

    }
}