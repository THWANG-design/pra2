package com.wang;

public class HashMap {
    static class Entry<K,V>{
        K key;
        V value;
        Entry<K,V>next;

        public Entry(K key, V value, Entry<K,V>next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }


    static class hashMap<K,V>{
        private static final int DEFAULT_SIZE = 16;
        private static final double DEFAULT_LOAD_FACTOR = 0.75;
        private double loadFactor;
        private int initCapacity;

        private Entry<K,V>[]table = null;

        public hashMap(){
            this.loadFactor = DEFAULT_LOAD_FACTOR;
            this.initCapacity = DEFAULT_SIZE;
            table = new Entry[this.initCapacity];
        }

        public int hash(K key){
            if(key == null)
                return 0;
            int h = key.hashCode();
            return h ^ h>>>16;
        }

        public void put(K key, V value){
            int index = hash(key) % (initCapacity - 1);
            if(table[index] != null){
                Entry<K,V>e = table[index];
                Entry<K,V>e2 = null;
                while(e != null){
                    if(hash(e.key) == hash(key) && e.key.equals(key)){
                        e.value = value;
                        break;
                    }
                    e2 = e;
                    e = e.next;
                }
                if(e == null){
                    e2.next = new Entry<K,V>(key,value,null);
                }

            }
            else{
                table[index] = new Entry<K,V>(key,value,null);
            }

        }

        public V get(K key){
            int index = hash(key) % (initCapacity - 1);
            if(table[index] == null)
                return null;

            Entry<K,V>temp = table[index];

            while(temp != null){
                if(hash(temp.key) == hash(key) && temp.key.equals(key)){
                    return temp.value;
                }
                temp = temp.next;
            }
            return null;
        }

        public static void main(String[] args) {
            HashMap.hashMap<String,Integer>map = new HashMap.hashMap<String,Integer>();
            map.put("wang", 1);
            map.put("tao", 2);
            map.put("han", 3);

            System.out.println(map.get("wang"));
            System.out.println(map.get("tao"));


        }

    }
}
