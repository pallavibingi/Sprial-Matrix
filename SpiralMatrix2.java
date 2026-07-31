/* to solve this we take 4 variables called: 
1 - top row
2- bottom row
3-left column 
4-right column
*/
/* here we observe that first ,we fill from left->right then
top->bottom , right->left, bottom -> top . by this we get a idea of taking 4 variables */

/* whenever we fill the left-> right then top++ means we fill one top row 
top-> bottom then right-- means we fill one right column
right->left then bottom-- means we fill one bottom row
bottom-> top then left++ means we fill one left column
*/
/* this logic is runs until there is no inner spaces which means there is no rows and columns 
i.e.., top<=bottom && left<=column */


class Solution {
    public int[][] generateMatrix(int n) {
        int top=0;
        int bottom=n-1;
        int left=0;
        int right=n-1;
        int num=1;

        int[][] res=new int[n][n];

        while(top<=bottom && left<=right){
            /* taking res[top][i] = means we are in top row and i is the moving column*/
            //left-->right
            for(int i=left;i<=right;i++){
                res[top][i]=num++;
            }
            top++; //one top row is completed
            //top-->bottom
            for(int i=top;i<=bottom;i++){
                res[i][right]=num++;
            }
            right--; // one right column is completed so need to come again
            //right-->left
            for(int i=right;i>=left;i--){
                res[bottom][i]=num++;
            }
            bottom--;
            //bottom-->top
            for(int i=bottom;i>=top;i--){
                res[i][left]=num++;
            }
            left++;

        }
        return res;
        
    }
}
