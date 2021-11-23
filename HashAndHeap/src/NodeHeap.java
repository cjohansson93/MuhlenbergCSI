public class NodeHeap {
    private Integer priority;
    private String name;

    public NodeHeap(Integer priority, String name){
        this.priority = priority;
        this.name = name;
    }

    public NodeHeap(){
        this.priority = null;
        this.name = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
