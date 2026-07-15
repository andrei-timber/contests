class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<int[]> pastTemps = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!pastTemps.isEmpty() 
                && pastTemps.peek()[0] < temperatures[i]) {
                int[] t = pastTemps.pop();
                result[t[1]] = i - t[1];
            }
            pastTemps.push(new int[]{temperatures[i], i});
        }
        return result;
    }
}
