public class numberWithEvenNumDigit {
    class Solution {
    public boolean checknum(int n){
        int even=0;
        
            while(n!=0){
                n/=10;
                even++;
            }
        
        return even % 2 ==0;
    }
    public int findNumbers(int[] nums) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            if(checknum(nums[i])){
                count++;
            }
            
        }
        return count;
    }
}
}
