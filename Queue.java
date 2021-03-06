package queue;
public class Queue {

    private int maxsize;
    private Object[] queuearray;
    private int head;
    private int tail;
    private int count;

    public Queue(int size) {
        maxsize = size;
        queuearray = new Object[maxsize];
        head = tail = -1;
    }

    public boolean isEmpty() {
        return tail == -1;
    }

    public boolean isFull() {
        return tail == queuearray.length - 1;
    }

    public void Enqueue(Object obj) {
        if (isEmpty()) {
            tail = 0;
            queuearray[tail] = obj;
        } else {
            if (!isFull()) {
                tail++;
                queuearray[tail] = obj;
            } else {
                System.out.println("List overflow");
            }
        }
    }

    public Object Dequeue() {
        Object e;
        int i;
        if (!isEmpty()) {
            e = queuearray[0];
            for (i = 1; i <= count; i++) {
                queuearray[i - 1] = queuearray[i];
            }
            tail--;
            return e;
        } else {
            System.out.println("List underflow");
        }
        return 0;
    }

    public boolean clear() {
        head = tail = -1;
        System.out.println("Data Clear");
        return false;
    }

    public void printQ() {
        System.out.print("Isi Queue: ");
        if (!isEmpty()) {
            for (int i = head; i <= maxsize - 1; i++) {
                System.out.print(queuearray[i] + " ");
            }
            System.out.println();
        } else {
            System.out.print("Data Kosong");
        }

    }
}
