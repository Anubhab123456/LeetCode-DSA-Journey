class Node{
    int val;
    Node next;
    public Node(int val,Node next){
        this.val=val;
        this.next=next;
    }
}
class MyCircularQueue {
    Node head,tail;
    int maxsize;
    int count;
    public MyCircularQueue(int k) {
        count=0;
        maxsize=k;
        head=null;
        tail=null;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        Node node=new Node(value,null);
        if(count==0){
            head=node;
            tail=node;
        }
        else{
            tail.next=node;
            tail=tail.next;
        }
        count++;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head=head.next;
        count--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return head.val;
    }
    
    public int Rear() {
         if(isEmpty()){
            return -1;
        }
        return tail.val;
    }
    
    public boolean isEmpty() {
        return count==0;
    }
    
    public boolean isFull() {
        return count==maxsize;
    }
}
