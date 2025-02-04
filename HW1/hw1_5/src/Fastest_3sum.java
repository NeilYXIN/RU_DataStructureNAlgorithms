import java.util.Collections;
import java.util.List;

public class Fastest_3sum {
    public int fastest_3sum(List<Integer> nums)
    {
        int count = 0;
        int len = nums.size();
        Collections.sort(nums);
        // fix the first number
        long startTime = System.currentTimeMillis();
        for(int i = 0; i < len - 2; i++)
        {
            int left = i + 1;
            int right = len - 1;
            // use two pointer to search the other two numbers
            while(left < right)
            {
                if(nums.get(left) + nums.get(right) + nums.get(i) == 0)
                {
                    count++;
                    int tleft = left;
                    int tright = right;
                    while(nums.get(left) == nums.get(tleft + 1) && tleft + 1 < right)
                    {
                        count++;
                        tleft++;
                    }
                    while(nums.get(right) == nums.get(tright - 1) && tright - 1 > left)
                    {
                        count++;
                        tright--;
                    }
                    left++;
                    right--;
                }
                else if(nums.get(left) + nums.get(right) + nums.get(i) < 0)
                    left++;
                else if(nums.get(left) + nums.get(right) + nums.get(i) > 0)
                    right--;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time duration in ms is: " + (endTime - startTime));
        return count;
    }
}
