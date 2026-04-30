class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

        for(List<String> ticket : tickets){
            graph.computeIfAbsent(ticket.get(0),k->new PriorityQueue<String>()).add(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>();
        dfs("JFK",graph,result);
        return result;
    }
    public void dfs(String source, Map<String,PriorityQueue<String>> graph, LinkedList<String> result){
        PriorityQueue<String> departures = graph.get(source);
        while(departures!=null && !departures.isEmpty()){
            dfs(departures.poll(),graph,result);
        }
        result.addFirst(source);
    }
}
// ["SEA","JFK"],["JFK","SEA"],["JFK","HOU"]
// result - 
// pq.jfk = sea, hou
// pq.hou = 
// pq.sea = jfk

// jfk,sea,jfk,hou


