class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        min_heap = [-stone for stone in stones]
        heapq.heapify(min_heap)
        while len(min_heap) > 1:
            x = heapq.heappop(min_heap)
            y = heapq.heappop(min_heap)
            if x < y:
                heapq.heappush(min_heap, x - y)
        return -min_heap[0] if min_heap else 0