package javalanguage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

/**
 * Created by hy on 2015/8/7.
 */
public class Set2Map <K,V>extends HashSet<SimpleEntry<K,V>> {
    public static void main(String[] args){
        Set2Map<String,Integer>map=new Set2Map<String, Integer>();
        map.put("yuwen",89);
    }



    public void clear(){
        super.clear();
    }
    public boolean containsKey(K key){
        return super.contains(new SimpleEntry<K, V>(key,null));
    }
    public boolean containsValue(V value){
        for(SimpleEntry<K,V>se:this){
            if(se.getValue().equals(value)){
                return true;
            }
        }
        return false;
    }
    public V get(K key){
        for(SimpleEntry<K,V>se:this){
            if(se.getKey().equals(key))
                return se.getValue();
        }
        return null;
    }
    public V put(K key,V value){
        add(new SimpleEntry<K, V>(key,value));
        return  value;
    }

    public void putAll(Map<? extends K,?extends V>m){
        for(K key:m.keySet()){
            add(new SimpleEntry<K, V>(key,m.get(key)));
        }
    }


    public int size(){
        return super.size();
    }

}

class SimpleEntry<K,V>implements Map.Entry<K,V>,Serializable{
    private  K key=null;
    private V value;
    public SimpleEntry(K key,V value){
        key=key;
        value=value;
    }
    public SimpleEntry(Map.Entry<? extends K,? extends V> map){
        this.key=map.getKey();
        this.value=map.getValue();
    }
    @Override
    public K getKey() {
        return  key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V tmp=value;
        this.value=value;
        return tmp;
    }

    public boolean equals(Object o){
        if(o==this)
           return true;
        if(o.getClass()==SimpleEntry.class){
            SimpleEntry se=(SimpleEntry) o;
            return se.getKey().equals(this.getKey());
        }
        return false;
    }

    public int hashCode(){
        return key==null?0:key.hashCode();
    }

    public String toString(){
        return key+"="+value;
    }

}