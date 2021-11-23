public class OpenHash {
    NodeHash[] hashTable;

    public OpenHash(){
        hashTable = new NodeHash[5];
    }

    public void insert(String key, String value){
        int index = getIndex(key);
        if (hashTable[index] == null){
            hashTable[index] = new NodeHash();
        }
        NodeHash temp = hashTable[index];
        while(true) {
            if (temp.next == null){
                NodeHash n = new NodeHash(key,value);
                temp.next = n;
                break;
            }
            else if (temp.next.getKey().equals(key)){
                temp.next.setValue(value);
                break;
            }
            else {
                temp = temp.next;
            }
        }
    }

    public boolean remove(String key){
        int index = getIndex(key);
        if (hashTable[index] == null){
            return false;
        }
        NodeHash temp = hashTable[index];
        while(true) {
            if (temp.next == null){
                return false;
            }
            else if (temp.next.getKey().equals(key)){
                temp.next = temp.next.next;
                return true;
            }
            else {
                temp = temp.next;
            }
        }
    }

    public String search(String key){
        int index = getIndex(key);
        if (hashTable[index] == null){
            return null;
        }
        NodeHash temp = hashTable[index];
        while(true) {
            if (temp.next == null){
                return null;
            }
            else if (temp.next.getKey().equals(key)){
                return temp.next.getValue();
            }
            else {
                temp = temp.next;
            }
        }
    }

    public void display(){
        for (int i = 0; i < hashTable.length; i++){
            if (hashTable[i] != null){
                NodeHash temp = hashTable[i];
                while (temp != null){
                    if (temp.getKey() != null){
                        System.out.println("Index: " + i + " Key: " + temp.getKey() + " Value: " + temp.getValue());
                    }
                    temp = temp.next;
                }
            }
        }
    }

    private int getIndex(String key){
        return key.hashCode()%5;
    }
}
