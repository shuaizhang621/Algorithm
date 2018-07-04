import myClass.GraphNode;

import java.util.*;

public class IsBipartite {
    public boolean isBipartite(List<GraphNode> graph) {
        if (graph == null || graph.size() == 0) {
            return false;
        }
        Map<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!BFS(node, visited)) {
                return false;
            }
        }
        return true;
    }

    private boolean BFS(GraphNode node, Map<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Queue<GraphNode> q = new LinkedList<>();
        q.offer(node);
        visited.put(node, 0);
        while (!q.isEmpty()) {
            GraphNode curNode = q.poll();
            int neiColor = visited.get(curNode) == 0 ? 1 : 0;
            for (GraphNode neiNode : curNode.neighbors) {
                if (visited.containsKey(neiNode)) {
                    if (visited.get(neiNode) != neiColor) {
                        return false;
                    }
                } else {
                    q.offer(neiNode);
                    visited.put(neiNode, neiColor);
                }
            }
        }
        return true;
    }
}
