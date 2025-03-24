import java.io.*;
import java.util.*;

class Record {
    String inTime;
    int min;
    boolean out;
    
    public Record(String inTime, int min) {
        this.inTime = inTime;
        this.min = min;
        this.out = false;
    }
}

class Solution {
    static Map<String, Record> cars = new HashMap<>();
    static PriorityQueue<String> pq = new PriorityQueue<>();
    static int minMin, minCost, unitMin, unitCost;
    
    public int[] solution(int[] fees, String[] records) {
        minMin = fees[0];
        minCost = fees[1];
        unitMin = fees[2];
        unitCost = fees[3];
        
        for (String record : records) {
            String[] info = record.split(" ");
            String time = info[0];
            String carNum = info[1];
            if (info[2].equals("IN")) {
                if (cars.containsKey(carNum)) {
                    cars.get(carNum).inTime = time;
                    cars.get(carNum).out = false;
                } else {
                    cars.put(carNum, new Record(time, 0));
                }
            } else {
                Record car = cars.get(carNum);
                car.min += calcMin(car.inTime, time);
                car.out = true;
            }
        }
        
        for (Map.Entry<String, Record> entry : cars.entrySet()) {
            Record car = entry.getValue();
            if (!car.out) car.min += calcMin(car.inTime, "23:59"); 
            pq.offer(entry.getKey());
        }
        int[] answer = new int[pq.size()];
        for (int i = 0; i < answer.length; i++) {
            String car = pq.poll();
            answer[i] = calcCost(cars.get(car).min);
        }
        return answer;
    }
    
    public int calcCost(int min) {
        int finalCost = minCost;
        if (min <= minMin) return finalCost;
        min -= minMin;
        finalCost += (min / unitMin) * unitCost;
        if (min % unitMin != 0) finalCost += unitCost;
        return finalCost;        
    }
    
    public int calcMin(String inTime, String outTime) {
        String[] in = inTime.split(":");
        String[] out = outTime.split(":");
        int hour = Integer.parseInt(out[0]) - Integer.parseInt(in[0]);
        int min = Integer.parseInt(out[1]) - Integer.parseInt(in[1]);
        return hour * 60 + min;
    }
}