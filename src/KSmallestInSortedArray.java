import java.util.Comparator;
import java.util.PriorityQueue;

public class KSmallestInSortedArray {
    public int kthSmallest(int[][] matrix, int k) {
        int M = matrix.length;
        int N = matrix[0].length;
        boolean[][] visited = new boolean[M][N];
        PriorityQueue<Cell> pq = new PriorityQueue<Cell>(k, new Comparator<Cell>() {
            @Override
            public int compare(Cell c1, Cell c2) {
                if (c1.value == c2.value) {
                    return 0;
                }
                return c1.value < c2.value ? -1 : 1;
            }
        });
        Cell cur = new Cell(0, 0, matrix[0][0]);
        pq.offer(cur);
        visited[0][0] = true;
        for (int i = 0; i < k; i++) {
            cur = pq.poll();
            if (cur.x < M - 1 && !visited[cur.x + 1][cur.y]) {
                pq.offer(new Cell(cur.x + 1, cur.y, matrix[cur.x + 1][cur.y]));
                visited[cur.x + 1][cur.y] = true;
            }
            if (cur.y < N - 1 && !visited[cur.x][cur.y + 1]) {
                pq.offer(new Cell(cur.x, cur.y + 1, matrix[cur.x][cur.y + 1]));
                visited[cur.x][cur.y + 1] = true;
            }
        }
        return cur.value;
    }

    class Cell {
        int x;
        int y;
        int value;
        public Cell(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }
}
