import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Demo {
    public static void main(String[] args) {
        int[] nums = {0, 8, 21, 1, 15};
        int target = 29;
        int[] res = threeSum(nums,target);
        System.out.println(Arrays.toString(res));

    }
    public static int[] threeSum(int[] nums,int target){
        //Input: nums = [2,11,7,20,15], target = 29
        //Output: [0,2,3]
        ArrayList<Integer> list = new ArrayList<>();
        for (int i =0;i<nums.length;i++){
            int[] res = twoSum(nums,target-nums[i]);
            if(res!=null){
                list.add(i);
                for (int num : res){
                    list.add(num);
                }
                break;
            }
        }

        int[] arr = list.stream().mapToInt(i->i).toArray();
        return arr;
    }
    public static int[] twoSum(int[] nums, int target){
        int[] res = new int[2];
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        for (int i =0;i<nums.length;i++){
            int a = target - nums[i];
            Integer index = map.get(a);
            if(index!=null && index !=i){
                res[0]=i;
                res[1]=index;
                return res;
            }

        }
        return res;
    }
}
