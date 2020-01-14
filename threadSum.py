from threading import Thread
import time

RList = [1, 2, 3, 4, 5, 6, 7, 8, 16, 64, 256, 1024]

N = 100000000

class threadSum(Thread):
    def __init__(self, s, e):
        Thread.__init__(self)
        self.s = s
        self.e = e
        self.sum = 0

    def run(self):
        for k in range(self.s, self.e + 1):
            self.sum += k

    def getSum(self):
        return self.sum


sum = 0
start = time.perf_counter_ns()
for k in range(1, N + 1):
    sum += k
elapsed = time.perf_counter_ns() - start
print("R =", 0, ":", elapsed)
#print(0, "  ", N, "  ", sum, "  ", elapsed)


for R in RList:
    sum = 0
    tList = []
    r = int(N / R)
    e = r
    s = 1
    start = time.perf_counter_ns()
    for i in range(R):
        if i == R - 1:
            e = 100000000
        t = threadSum(s, e)
        t.setName("Thread" + str(i + 1))
        t.start()
        tList.append(t)
        s += r
        e += r

    for i in range(R):
        tList[i].join()
        sum += tList[i].getSum()
    elapsed = time.perf_counter_ns() - start
    #print(R, "  ", N, "  ", sum, "  ", elapsed)
    print("R =", R, ":", elapsed)





