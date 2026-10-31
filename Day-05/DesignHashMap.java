import java.util.List;
import java.util.LinkedList;
import java.util.Iterator;
class pair<u,v>{
    u first;
    v second;
    public pair(u f,v s){
        first=f;
        second=s;
    }
}
class Bucket{
    List<pair<Integer,Integer>> list;
    public Bucket(){
        list=new LinkedList<pair<Integer,Integer>>();
    }
    public void put(int key,int val){
        for(pair<Integer,Integer> p:list){
            if(p.first==key){
                p.second=val;
                return;
            }
        }
        list.addFirst(new pair<Integer,Integer>(key,val));
    }
    public int get(int key){
        for(pair<Integer,Integer> p:list){
            if(p.first==key){
                return p.second;
            }
            
        }
        return -1;
    }
public void remove(int key) {
    Iterator<pair<Integer,Integer>> it = list.iterator();

    while (it.hasNext()) {
        pair<Integer,Integer> p = it.next();

        if (p.first == key) {
            it.remove();
            return;
        }
    }
}}
class MyHashMap {
    Bucket[] bucket;
    int keyrange=769;
    public MyHashMap() {
        bucket=new Bucket[769];
        for(int i=0;i<keyrange;i++){
            this.bucket[i]=new Bucket();
        }
    }
    public int getindex(int key){
        return key%keyrange;
    }
    public void put(int key, int value) {
        int bucketindex=this.getindex(key);
        this.bucket[bucketindex].put(key,value);
    }
    
    public int get(int key) {
        int bucketindex=this.getindex(key);
        return this.bucket[bucketindex].get(key);
    }
    
    public void remove(int key) {
        int bucketindex=this.getindex(key);
        this.bucket[bucketindex].remove(key);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */