另外本题还有一种很简单直观的方法，削头旋转方法
```python
def spiralOrder(self, matrix: List[List[int]]) -> List[int]:
        res = []
        while matrix:
            # 削头（第一层）
            res += matrix.pop(0)
            # 将剩下的逆时针转九十度，等待下次被削
            matrix = list(zip(*matrix))[::-1]
        return res
```

```java
  public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        while (matrix.length>=1){
            for (int num : matrix[0]) {
                res.add(num);
            }
            matrix=reversalArr(matrix);
        }
        return res;
    }
    private int[][] reversalArr(int[][] matrix) {
        int m = matrix[0].length;
        int n = matrix.length - 1;
        int[][] reArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                reArr[i][j]=matrix[j+1][m-i-1];
            }
        }
        return reArr;
    }
```