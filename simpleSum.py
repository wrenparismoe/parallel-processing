import time

N = 100000000
sum = 0
start = time.perf_counter_ns()
for k in range(1, N+1):
    sum += k
elapsed = time.perf_counter_ns() - start

print(N, "  ", sum, "  ", elapsed)