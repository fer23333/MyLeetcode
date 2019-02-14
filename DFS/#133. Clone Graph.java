/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null){
            return node;
        }
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();   
        //initilize
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        Queue<UndirectedGraphNode> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            UndirectedGraphNode cur  = q.poll();
            if(cur.neighbors == null){
                continue;
            }
            for(UndirectedGraphNode neighbor : cur.neighbors){
                if(!map.containsKey(neighbor)){
                    //first time visiting this neighbor
                    UndirectedGraphNode tempNode = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, tempNode);
                    q.offer(neighbor); 
                }
                map.get(cur).neighbors.add(map.get(neighbor));                 
            }    
  
        }
        return map.get(node);
    }
}
