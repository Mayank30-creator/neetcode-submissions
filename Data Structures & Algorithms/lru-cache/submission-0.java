class LRUCache {

    int capacity;
    Map<Integer,Node> map = new HashMap<>();
    Node head = new Node();
    Node tail = new Node();
    
    static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(){} 

        Node(int key,int value){
           this.key=key;
           this.value=value;
           this.prev=null;
           this.next=null;
        }
    }

    public LRUCache(int capacity) {
         this.capacity=capacity;
         head.next=tail;
         tail.prev=head;  
    }
    
    public int get(int key) {
      if(!map.containsKey(key)){
        return -1;
      }
      
        Node node = map.get(key);
        deleteNode(node);
        insertBeginning(node);
      
       return node.value;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            deleteNode(node);
            insertBeginning(node);
            return;
        }
        else{
            if(capacity==map.size()){
                Node lru = tail.prev;
                map.remove(lru.key);
                deleteNode(lru); 
            }
            Node node = new Node(key,value);
            insertBeginning(node);
            map.put(key,node);
        }
        
    }

    public void deleteNode(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insertBeginning(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
}
