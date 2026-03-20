package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Problem: 1557. Minimum Number of Vertices to Reach All Nodes
Link: https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

Difficulty: Medium
Pattern: Graph / Indegree

Approach:
- Count indegree of every node
- Any node with indegree 0 must be included in the answer
- Nodes with indegree > 0 can be reached from some other node

Time Complexity: O(V + E)
Space Complexity: O(V)
*/
public class MinimumNumberOfVerticesToReachAllNodes {

	public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        List<Integer> result = new ArrayList<>();
        int[] indegree = new int[n];
       
        for (List<Integer> edge : edges) {
            int to = edge.get(1);
            indegree[to]++;
        }

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                result.add(i);
            }
        }

        return result;
    }
	
	public static void main(String[] args) {
        MinimumNumberOfVerticesToReachAllNodes sol =
                new MinimumNumberOfVerticesToReachAllNodes();

        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1));
        edges.add(Arrays.asList(0, 2));
        edges.add(Arrays.asList(2, 5));
        edges.add(Arrays.asList(3, 4));
        edges.add(Arrays.asList(4, 2));

        int n = 6;

        System.out.println(sol.findSmallestSetOfVertices(n, edges)); // [0, 3]
    }
}
