class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        int startRow=0;
        int endRow=matrix.length-1;
        int startCol=0;
        int endCol=matrix[0].length-1;
        while(startRow<=endRow && startCol<=endCol)
        {
            
            //left to right
            for(int i=startCol;i<=endCol;i++)
            {
                ans.add(matrix[startRow][i]);
            }
            //top to bottom
            for(int i=startRow+1;i<=endRow;i++)
            {
                ans.add(matrix[i][endCol]);
            }
            // right to left
            for(int i=endCol-1;i>=startCol;i--)
            {
                if(startRow==endRow)break;
                ans.add(matrix[endRow][i]);
            }
            // bottom to top
            for(int i=endRow-1;i>startRow;i--)
            {
                if(startCol==endCol)break;
                ans.add(matrix[i][startCol]);
            }
            startRow++;
            startCol++;
            endRow--;
            endCol--;
        }
        return ans;
        
        
    }
}