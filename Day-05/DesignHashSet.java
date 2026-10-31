import java.util.List;
import java.util.LinkedList;
class Bucket{
    private List<Integer> container;
    public Bucket(){
        this.container=new LinkedList<Integer>();
    }
    public void insert(Integer val){
        int index=this.container.indexOf(val);
        if(index==-1){
            this.container.addFirst(val);
        }
    }
    public void remove(Integer val){
        this.container.remove(val);
    }
    public boolean contain(Integer val){
        int index=this.container.indexOf(val);
        return index!=-1;
    }
}
class MyHashSet {
    int bucketnum=769;
    private Bucket buckets[];
    public MyHashSet(){
        this.buckets=new Bucket[this.bucketnum];
        for(int i=0;i<bucketnum;i++){
            this.buckets[i]=new Bucket();
        }    }
    public int getindex(int key){
        return key%bucketnum;
    }
    
    public void add(int key) {
        int bucketindex=this.getindex(key);
        this.buckets[bucketindex].insert(key);
    }
    
    public void remove(int key) {
        int bucketindex=this.getindex(key);
        this.buckets[bucketindex].remove(key);
    }
    
    public boolean contains(int key) {
        int bucketindex=this.getindex(key);
        return this.buckets[bucketindex].contain(key);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
