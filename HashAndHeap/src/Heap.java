public class Heap {
    NodeHeap[] heap;
    int top;

    public Heap(){
        heap = new NodeHeap[100];
        top = 0;
    }

    public void insert(int priority, String name){
        if (!(top == heap.length -1)){
            top++;

            int i = top;
            for (; i > 1 && priority < heap[i/2].getPriority(); i = i/2){
                heap[i] = heap[i/2];
            }
            heap[i] = new NodeHeap(priority,name);
        }
    }

    public void remove(){
        if (top == 1){
            heap[top] = null;
            top--;
        }
        else if (top > 1){
            heap[1] = heap[top];
            heap[top] = null;
            top--;
            for (int i = 1; i <= top/2;){
                int c = i*2;
                if (c < top){
                    if (heap[c].getPriority() > heap[c+1].getPriority()){
                        c++;
                    }
                }
                if (heap[i].getPriority() > heap[c].getPriority()){
                    NodeHeap temp = heap[i];
                    heap[i] = heap[c];
                    heap[c] = temp;
                    i = c;
                }
                else {
                    break;
                }
            }
        }
    }

    public void search(String name){
        for (int i = 1; i <= top; i++){
            if (heap[i].getName().equals(name)){
                System.out.println("Index: "+ i +" Name: " + heap[i].getName() +" Rank: " + heap[i].getPriority());
                return;
            }
        }
        System.out.println(name + ", does not exist.");
    }

    public void display(){
        for (int i = 1; i <= top; i++){
            System.out.println("Index: "+ i +" Name: " + heap[i].getName() +" Rank: " + heap[i].getPriority());
        }
    }
}