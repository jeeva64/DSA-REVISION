class Triplet {
    double root;
    int x, y;
    Triplet(double root, int x, int y) {
        this.root = root;
        this.x = x;
        this.y = y;
    }
}
//CUSTOM COMPARATOR FOR PRIORITY BASED SORTING
class TripletComparator implements Comparator<Triplet> {
    public int compare(Triplet a, Triplet b) {
        if(a.root > b.root)
            return 1;
        else if(a.root < b.root)
            return -1;
        return 0;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Triplet> queue = new PriorityQueue<Triplet>(new TripletComparator());

        for(int[] point : points) {
            int x = point[0];
            int y = point[1];
            //Euclidean Distance as Priority in Min Heap
            double dist = Math.sqrt((-x * -x) + (-y * -y));
            queue.add(new Triplet(dist, x, y));
        }

        int[][] result = new int[k][2];
        int idx = 0;
        //Get Top Kth Triplet based on Priority
        while(k-- > 0) {
            result[idx][0] = queue.peek().x;
            result[idx++][1] = queue.peek().y;
            queue.poll();
        }
        return result;
    }
}