import java.util.*;

class Process {
    int pid;          // Process ID
    int arrivalTime;  // Waktu tiba
    int burstTime;    // Waktu eksekusi
    int waitingTime;  // Waktu tunggu
    int remainingTime; // Untuk Round Robin

    public Process(int pid, int arrivalTime, int burstTime) {
        this.pid = pid;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.waitingTime = 0;
        this.remainingTime = burstTime;
    }
}

public class CPUSchedulingSimulation {

    // First Come First Served (FCFS)
    public static double fcfs(List<Process> processes) {
        int time = 0;
        int totalWaitingTime = 0;

        for (Process p : processes) {
            if (time < p.arrivalTime) time = p.arrivalTime;
            p.waitingTime = time - p.arrivalTime;
            time += p.burstTime;
            totalWaitingTime += p.waitingTime;
        }
        return (double) totalWaitingTime / processes.size();
    }

    // Shortest Job First (Non-preemptive)
    public static double sjf(List<Process> processes) {
        List<Process> readyQueue = new ArrayList<>();
        int time = 0, completed = 0, totalWaitingTime = 0;

        while (completed < processes.size()) {
            for (Process p : processes) {
                if (p.arrivalTime <= time && !readyQueue.contains(p) && p.waitingTime == 0 && p.remainingTime == p.burstTime) {
                    readyQueue.add(p);
                }
            }
            if (!readyQueue.isEmpty()) {
                readyQueue.sort(Comparator.comparingInt(p -> p.burstTime));
                Process current = readyQueue.remove(0);

                if (time < current.arrivalTime) time = current.arrivalTime;
                current.waitingTime = time - current.arrivalTime;
                time += current.burstTime;
                totalWaitingTime += current.waitingTime;
                completed++;
            } else {
                time++;
            }
        }
        return (double) totalWaitingTime / processes.size();
    }

    // Round Robin
    public static double roundRobin(List<Process> processes, int quantum) {
        Queue<Process> queue = new LinkedList<>();
        int time = 0, completed = 0, totalWaitingTime = 0;

        while (completed < processes.size()) {
            for (Process p : processes) {
                if (p.arrivalTime == time) {
                    queue.add(p);
                }
            }
            if (!queue.isEmpty()) {
                Process current = queue.poll();
                int execTime = Math.min(quantum, current.remainingTime);

                if (current.remainingTime == current.burstTime) {
                    current.waitingTime += time - current.arrivalTime;
                } else {
                    current.waitingTime += time - (current.burstTime - current.remainingTime);
                }

                time += execTime;
                current.remainingTime -= execTime;

                for (Process p : processes) {
                    if (p.arrivalTime > time - execTime && p.arrivalTime <= time) {
                        queue.add(p);
                    }
                }

                if (current.remainingTime > 0) {
                    queue.add(current);
                } else {
                    totalWaitingTime += current.waitingTime;
                    completed++;
                }
            } else {
                time++;
            }
        }
        return (double) totalWaitingTime / processes.size();
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10; // jumlah proses (bisa diganti 100 sesuai kebutuhan)
        int quantum = 4;

        List<Process> processes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int arrivalTime = rand.nextInt(10);
            int burstTime = rand.nextInt(10) + 1;
            processes.add(new Process(i + 1, arrivalTime, burstTime));
        }

        // Copy list agar tidak merusak data
        double avgFCFS = fcfs(new ArrayList<>(processes));
        double avgSJF = sjf(new ArrayList<>(processes));
        double avgRR = roundRobin(new ArrayList<>(processes), quantum);

        System.out.println("Hasil simulasi scheduling CPU:");
        System.out.println("FCFS Average Waiting Time : " + avgFCFS);
        System.out.println("SJF  Average Waiting Time : " + avgSJF);
        System.out.println("RR   Average Waiting Time : " + avgRR);
    }
}



