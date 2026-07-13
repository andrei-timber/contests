class Solution {
    // TreeMap can be simpler here, but the below is linear and faster.
    public int[] topKFrequent(int[] nums, int k) {
        // Build the histogram first
        HashMap<Integer, Integer> hist = new HashMap<>();
        for (int num : nums) {
            hist.putIfAbsent(num, 0);
            hist.put(num, hist.get(num) + 1);
        }
        
        // Invert the histogram into array of lists by counter as idx
        List<Integer>[] counterList = new List[nums.length + 1];
        for (int i = 0; i < counterList.length; i++) {
            counterList[i] = new ArrayList<>();
        }
        for (int num : hist.keySet()) {
            counterList[hist.get(num)].add(num);
        }
        
        // Return the last k elements of a flattened array above
        int[] output = new int[k];
        int idx = 0;
        for (int i = counterList.length - 1; i >= 0 && idx < k; i--) {
            for (int num : counterList[i]) {
                output[idx++] = num;
                if (idx == k) return output;
            }
        }
        return output;
    }
}
