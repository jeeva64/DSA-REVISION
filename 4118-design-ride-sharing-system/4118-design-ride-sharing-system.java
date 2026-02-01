class RideSharingSystem {
    private List<Integer> rider;
    private List<Integer> driver;
    
    public RideSharingSystem() {
        rider = new ArrayList<>();
        driver = new ArrayList<>();
    }
    
    public void addRider(int riderId) {
        rider.add(riderId);
    }
    
    public void addDriver(int driverId) {
        driver.add(driverId);
    }
    
    public int[] matchDriverWithRider() {
        int[] result = {-1, -1};
        if(!rider.isEmpty() && !driver.isEmpty()) {
            result[0] = driver.get(0);
            driver.remove(0);

            result[1] = rider.get(0);
            rider.remove(0);
        }
            
        return result;
    }
    
    public void cancelRider(int riderId) {
        if(rider.contains(riderId))
            rider.remove(Integer.valueOf(riderId));
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */