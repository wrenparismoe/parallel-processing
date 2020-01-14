# Parallel Processing
## Introduction

Multi-threading is used to divide tasks into smaller, more manageable workloads to be completed concurrently. The method allows multiple threads within a single-processor system to execute independently while sharing the same resources. In general, modern processors are constructed of multiple cores. Within each core are threads that can be utilized to run multiple processes at once. Without threads, a processor must perform tasks consecutively, one after the other. This causes assigned tasks to run in queue fashion where a single time-consuming task forces the remaining ones to wait until it finishes. When implemented properly, taking manual control of thread use within a processor can greatly increase the runtime of a program.

## Procedure

Included are a series of tests used to determine the effectiveness of multi-threading in Java and Python. Multi-threading was tested through computing the sum of the first 100,000,000 positive integers. To start off, the sum was computed in a single for loop without the use of threading. Then, threading was implemented by computing the entire sum in a single for loop within a single thread. Next N was split into R equal sized integer partitions to be computed in parallel on separate threads. The partial sums were added to get the total sum. Many variations were tested with R = 2, 3, 4, 5, 6, 7, and 8. Then, R was set to 16, 64, 256, and 1024. Note that these values exceeded the physical number of threads within the CPU of the computer used in the tests. The programs were implemented in Java and Python.

Computing the sum in a single for loop without multi-threading was simple. This program was called simpleSum. The sum was timed over 10 trials to record an accurate average runtime. The number of nanoseconds since the start of the day was recorded directly before and after the program was run. The difference between the two values was calculated to get the runtime of the process.

Computing the total sum with multi-threading was more complex and required the use of an object class that extended the Java Thread class. This class was called threadSum. A tester class was used to facilitate the process by creating and initializing threads for the given R values. This was named threadSumTester. A single clas was needed for the Python implementation and was named threadSum. To change the number of threads used to compute the sum simply alter the global variable R at the top of the program.

## Summary of Findings

Java performed better than Python when computing the sum of the first 100,000,000 positive integers. Finding the sum in Java was almost instantaneous while the same program in Python caused a significant waiting time. There was a distinct difference between the two programming languages. Java reached its fastest runtime when a thread count of R = 8 was used while Python was its most efficient without the use of threading. For Python, the attempt to divvy up the workload through multi-threading ended up making the algorithm slower, the exact opposite of the goal of the technique. 

The languages had such different results because of Python’s use of the Global Interpreter Lock (GIL). The GIL makes true concurrent multi-threading impossible. The python compiler uses the GIL to jump between threads in order to complete a task in the most efficient manner. The GIL will move between threads but no two will truly be active at the same time. This causes multi-threading to be an inefficient technique in Python. Having R = 1 restricted the GIL from processing a program on multiple threads. Essentially, instead of letting the compiler find the best way to complete a task by moving the GIL itself, attempting to use parallel processing restricts it to only one thread. Using two threads restricted the GIL to only jumping between two. This is faster than using a single thread but slower than letting the compiler complete the task on its own. As the thread count increased, more partial sums are computed at once with the GIL.

Java on the other hand was able to implement true multi-threading without the existence of a GIL equivalent. The CPU used in the computer to implement the programs was an Intel Core i7-8850H. This CPU is quad core with hyperthreading giving it up to eight processable threads. This explains why Java reached its fastest runtime at R = 8. All 8 threads were run in parallel with a partial sum assigned to each available thread. This is the most efficient way to utilize true multi-threading on a single-processor system. Initializing more than 8 threads caused additional threads to wait until a thread finished when it could take its place. After using 8 threads, every increment of R resulted in worse runtimes than the last. When utilizing multi-threading it is important to take note of the specific computer hardware that is being used. This allows the technique to be implemented effectively.

