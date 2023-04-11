package hackerrank;

import java.io.*;
        import java.math.*;
        import java.security.*;
        import java.text.*;
        import java.util.*;
        import java.util.concurrent.*;
        import java.util.regex.*;


public class CastleGrid {
    static class Cell {
        int row, col;
        Cell(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Node implements Comparable<Node> {
        int row, col, dist;
        Node(int row, int col, int dist) {
            this.row = row;
            this.col = col;
            this.dist = dist;
        }

        public int compareTo(Node other) {
            return Integer.compare(dist, other.dist);
        }
    }

    static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {
        int n = grid.size();
        int m = grid.get(0).length();
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(startX, startY, 0));
        dist[startX][startY] = 0;

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (node.row == goalX && node.col == goalY) {
                return node.dist;
            }
            if (visited[node.row][node.col]) continue;
            visited[node.row][node.col] = true;

            for (int[] dir : directions) {
                int r = node.row + dir[0];
                int c = node.col + dir[1];
                int d = node.dist;
                while (r >= 0 && r < n && c >= 0 && c < m && grid.get(r).charAt(c) == '.') {
                    d++;
                    if (d < dist[r][c]) {
                        dist[r][c] = d;
                        pq.offer(new Node(r, c, d));
                    }
                    r += dir[0];
                    c += dir[1];
                }
            }
        }

        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("src/hackerrank/result"));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
