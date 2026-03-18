package graphs;

/*
Problem: 547. Number of Provinces
Link: https://leetcode.com/problems/number-of-provinces/

Difficulty: Medium
Pattern: Graph DFS / Connected Components

Key Insight:
- Problem reduces to counting connected components in a graph

Approach:
- Treat each city as a node
- Use adjacency matrix directly
- Run DFS from each unvisited node
- Each DFS call represents one province

Time Complexity: O(n^2)
Space Complexity: O(n)
*/

public class NumberOfProvinces {

	// Function to find the province count
    public int findProvinces(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                dfs(isConnected, visited, city);
                provinces++;
            }
        }

        return provinces;
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int city) {
        visited[city] = true;

        for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, visited, neighbor);
            }
        }
    }

    // Simple test cases
    public static void main(String[] args) {
        NumberOfProvinces obj = new NumberOfProvinces();

        int[][] graph1 = {
            {1,1,0},
            {1,1,0},
            {0,0,1}
        };

        int[][] graph2 = {
            {1,0,0},
            {0,1,0},
            {0,0,1}
        };

        System.out.println("Provinces (graph1): " + obj.findProvinces(graph1)); // 2
        System.out.println("Provinces (graph2): " + obj.findProvinces(graph2)); // 3
    }
}
