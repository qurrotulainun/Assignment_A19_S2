package listarray;
public class ListArray {

    private Object[] listAr;
    private int first;

    public ListArray(int kapasitas) {
        listAr = new Object[kapasitas];
        first = -1;
    }

    public boolean IsEmpty() {
        return first == -1;
    }

    public boolean IsFull() {
        return (first == listAr.length - 1);
    }

    public void InsertFirst(Object elemen) {
        if (IsEmpty()) {
            first = 0;
            listAr[first] = elemen;
        } else {
            if (!IsFull()) {
                first++;
                listAr[first] = elemen;
            } else {
                System.out.println("List overflow");
            }
        }
    }

    public void InsertAfter(int index, Object elemen) {
        if (!IsFull()) {
            for (int i = first; i >= index; i--) {
                listAr[i + 1] = listAr[i];
            }
            listAr[index] = elemen;
            first++;
        } else {
            System.out.println("List overflow");
        }
    }

    public void InsertLast(Object elemen) {
        if (IsEmpty()) {
            first = 0;
            listAr[first] = elemen;
        } else {
            if (!IsFull()) {
                for (int i = first; i >= 0; i--) {
                    listAr[i + 1] = listAr[i];
                }
                listAr[0] = elemen;
                first++;
            } else {
                System.out.println("List overflow");
            }
        }
    }

    public Object DeleteFirst() {
        Object x;
        if (!IsEmpty()) {
            x = listAr[first];
            first--;
            return x;
        } else {
            System.out.println("under flow");
        }
        return 0;
    }

    public Object DeleteAfter(int index) {
        Object x;
        if (!IsEmpty()) {
            x = listAr[index];
            for (int i = index; i < first; i++) {
                listAr[i] = listAr[i + 1];
            }
            first--;
            return (x);
        } else {
            return ("List underflow");
        }
    }

    public Object DeleteLast() {
        Object x;
        if (!IsEmpty()) {
            x = listAr[0];
            for (int i = 0; i < first; i++) {
                listAr[i] = listAr[i + 1];
            }
            first--;
            return (x);
        } else {
            System.out.println("List underflow");
        }
        return 0;
    }
}