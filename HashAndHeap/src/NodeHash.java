public class NodeHash {
    private String key;
    private String value;
    public NodeHash next;

    public NodeHash(String key, String value){
        this.key = key;
        this.value = value;
        next = null;
    }

    public NodeHash(){
        this.key = null;
        this.value = null;
        next = null;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
