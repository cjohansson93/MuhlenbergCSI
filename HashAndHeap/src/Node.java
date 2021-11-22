public class Node<T> {
    private String name;
    private T value;
    public Node<T> next;

    public Node(String name, T value){
        this.name = name;
        this.value = value;
        next = null;
    }

    public Node(){
        this.name = null;
        this.value = null;
        next = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
