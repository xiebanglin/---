package com.xbl.queue;

public class ArrayQueue1 {
    public static void main(String[] args) {

        ArrayQueue arrayQueue = new ArrayQueue(3);
        arrayQueue.add(1);
        arrayQueue.add(2);
        arrayQueue.add(3);
        arrayQueue.add(3);
        arrayQueue.showQueue();
        arrayQueue.out();
        arrayQueue.showQueue();
        arrayQueue.out();
        arrayQueue.showQueue();
        arrayQueue.out();
        arrayQueue.out();
    }
}

class ArrayQueue {

    public int maxSize;
    public int front;
    public int rear;
    public int[] arr;

    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public void add(int val) {
        // 判断队列是否满
        if (isFull()) {
            System.out.println("队列已满，添加失败！");
            return;
        }
        rear++;
        arr[rear] = val;
        System.out.println("添加成功！");
    }

    public Integer out() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空！");
        }
        front++;
        return arr[front];
    }

    public void showQueue(){
        System.out.println("队列中的数据：");
        for (int i = front + 1; i <arr.length ; i++) {
            System.out.printf("%d\t", arr[i]);
        }
    }
}