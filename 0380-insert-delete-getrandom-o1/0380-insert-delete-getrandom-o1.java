class RandomizedSet {

    private Map<Integer, Integer> map;
    //Array for O(1) Removal
    private ArrayList<Integer> arr;
    private Random random;
    
    public RandomizedSet() {
        map = new HashMap<>();
        arr = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val){
        boolean isExist = map.containsKey(val);
        //Insert to map,arr,if not exist 
        if(!isExist){
            arr.add(val);
            //val as key,arr idx as value
            map.put(val, arr.size()-1);
        }
        return !isExist;
    }
    
    public boolean remove(int val) {

        if(!map.containsKey(val)){
            return false;
        }
        
        //Gets val index for swapping 
        int index = map.get(val);
        //Gets last index from arr
        int lstIdx = arr.size() - 1;
        //Gets lstIdx value from arr     
        int lastVal = arr.get(lstIdx);

        //swap val to last index
        arr.set(index, lastVal);
        
        //update map idx after removal
        map.put(lastVal, index);
        
        //Remove by O(1)
        arr.remove(lstIdx);
        map.remove(val);

        return true;
    }
    
    public int getRandom(){
    //Get valid index fron array & return 
        int idx = random.nextInt(arr.size());
        return arr.get(idx);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */