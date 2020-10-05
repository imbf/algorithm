package highscorekit.stack_queue.truckpassingthebridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TruckPassingTheBridge {
    
    @Test
    public void test() {
        assertEquals(solution(2, 10, new int[]{7, 4, 5, 6}), 8);
        assertEquals(solution(100, 100, new int[]{10}), 101);
        assertEquals(solution(100, 100, new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}), 110);
    }
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 1;
        int countOfPassedTruck = 0;
        List<Truck> passingTrucks = new ArrayList<>();
        int i = 0;
        while (countOfPassedTruck != truck_weights.length) {
            if (i != truck_weights.length && passingTrucks.stream().mapToInt(truck -> truck.getWeight()).sum() + truck_weights[i] <= weight) {
                passingTrucks.add(new Truck(truck_weights[i]));
                i++;
            }
            passingTrucks.stream().forEach(Truck::move);
            if (passingTrucks.get(0).isPassed(bridge_length)) {
                passingTrucks.remove(0);
                countOfPassedTruck++;
            }
            time++;
        }
        return time;
    }
}

class Truck {
    private int weight;
    private int position;
    
    public Truck(int weight) {
        this.weight = weight;
        this.position = 0;
    }
    
    public int getWeight() {
        return weight;
    }
    
    public void move() {
        position++;
    }
    
    public boolean isPassed(int length) {
        return position == length;
    }
}

/*
class Solution {
    class Truck {
        int weight;
        int move;

        public Truck(int weight) {
            this.weight = weight;
            this.move = 1;
        }

        public void moving() {
            move++;
        }
    }

    public int solution(int bridgeLength, int weight, int[] truckWeights) {
        Queue<Truck> waitQ = new LinkedList<>();
        Queue<Truck> moveQ = new LinkedList<>();

        for (int t : truckWeights) {
            waitQ.offer(new Truck(t));
        }

        int answer = 0;
        int curWeight = 0;

        while (!waitQ.isEmpty() || !moveQ.isEmpty()) {
            answer++;

            if (moveQ.isEmpty()) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
                continue;
            }

            for (Truck t : moveQ) {
                t.moving();
            }

            if (moveQ.peek().move > bridgeLength) {
                Truck t = moveQ.poll();
                curWeight -= t.weight;
            }

            if (!waitQ.isEmpty() && curWeight + waitQ.peek().weight <= weight) {
                Truck t = waitQ.poll();
                curWeight += t.weight;
                moveQ.offer(t);
            }
        }

        return answer;
    }
}
*/