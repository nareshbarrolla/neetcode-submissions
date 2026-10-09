class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
     if(matrix.length == 0){
        return false;
     }
     int start = 0;
     int end =  (matrix.length * matrix[0].length)-1;
     while(start <= end){
        int n = matrix[0].length;
        int mid = start + (end - start)/2;
        int i = mid/n;
        int j = mid%n;
        if(matrix[i][j] == target){
            return true;
        } else if(matrix[i][j] > target){
            end = mid-1;
        }else{
            start = mid+1;
        }
     }
     return false;  
    }
}
