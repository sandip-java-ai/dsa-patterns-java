package graphs;

import java.util.ArrayList;
import java.util.List;

/*
Problem: 802. Find Eventual Safe States
Link: https://leetcode.com/problems/find-eventual-safe-states/

Difficulty: Medium
Pattern: Graph DFS / Cycle Detection in Directed Graph

Approach:
- Use DFS with 3 states:
  0 = unvisited
  1 = visiting
  2 = safe
- If we see a visiting node again, a cycle exists
- If all neighbors are safe, current node is safe

Time Complexity: O(V + E)
Space Complexity: O(V)
*/

public class EventualSafeStates {

	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> result = new ArrayList<>();
        int n = graph.length;
        int[] state = new int[n];// 0 = unvisited, 1 = visiting, 2 = safe
        for(int i=0; i< n; i++) {
            if(dfs(graph, i, state)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean dfs(int[][] graph, int node, int[] state) {
        // already processed
        if (state[node] != 0) {
            return state[node] == 2;
        }

        // mark as visiting
        state[node] = 1;

        for (int neighbor : graph[node]) {
            // cycle found OR neighbor is unsafe
            if (state[neighbor] == 1 || !dfs(graph, neighbor, state)) {
                return false;
            }
        }

        // all neighbors are safe
        state[node] = 2;
        return true;

    }
    
    public static void main(String[] args) {
        EventualSafeStates sol = new EventualSafeStates();

        int[][] graph = {
            {1, 2},   // 0
            {2, 3},   // 1
            {5},      // 2
            {0},      // 3 (cycle here)
            {5},      // 4
            {},       // 5 (terminal)
            {}        // 6 (terminal)
        };

        List<Integer> result = sol.eventualSafeNodes(graph);

        System.out.println("Safe Nodes: " + result);
    }
}
