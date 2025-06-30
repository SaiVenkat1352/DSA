class Solution {
    public void setZeroes(int[][] matrix) {
        
        int row=matrix.length;
        int col=matrix[0].length;
        int rowArray[]=new int [row];
        int colArray[]=new int [col];
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(matrix[i][j]==0)
                {
                    rowArray[i]=1;
                    colArray[j]=1;

                }
            }
        }
        for(int i=0;i<row;i++)
        {
            for(int j=0;j<col;j++)
            {
                if(rowArray[i]==1 || colArray[j]==1 )
                {
                    matrix[i][j]=0;
                }
            }
        }
        
    }
    
}