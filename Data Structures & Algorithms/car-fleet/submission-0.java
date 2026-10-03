class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
     int n = position.length;
        if (n == 0) return 0;

        // Pair position and speed together
        double[][] cars = new double[n][2];
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i]; // Store time to target
        }

        // Sort cars by position in descending order (closest to target first)
        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0]));

        int fleets = 0;
        double currentMaxTime = 0;

        for (int i = 0; i < n; i++) {
            double timeToTarget = cars[i][1];
            
            // If this car takes more time than the current fleet lead, 
            // it cannot catch up and starts a new fleet.
            if (timeToTarget > currentMaxTime) {
                fleets++;
                currentMaxTime = timeToTarget;
            }
            // If timeToTarget <= currentMaxTime, it joins the existing fleet.
        }

        return fleets;   
    }
}
