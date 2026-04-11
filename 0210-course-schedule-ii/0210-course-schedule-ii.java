class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adjList = new ArrayList<>();

        //Step 1: Populate inDegree and create empty arraylist
        for(int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }
        //Step 2: Populate Adjacency List from prerequisites edge list
        for(int[] neighbor : prerequisites) {
            int u = neighbor[0];
            int v = neighbor[1];
            //1 based Index
            adjList.get(v).add(u);
            inDegree[u]++;
        }

        //Step 3: BFS with Kahn's Alogorithm 
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            //No Pre Requisite course
            if(inDegree[i] == 0)
                queue.offer(i);
        }

        //Topological sort order for course schedule to complete
        int[] order = new int[numCourses];
        int count = 0;
        while(!queue.isEmpty()) {
            int node = queue.poll();
            order[count++] = node;

            for(int neighbor : adjList.get(node)) {
                inDegree[neighbor]--;
                if(inDegree[neighbor] == 0)
                    queue.offer(neighbor);
            }
        }
        //If valid then return order, else empty array
        return count == numCourses ? order : new int[0];
    }
}