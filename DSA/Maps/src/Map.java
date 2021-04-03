import java.util.ArrayList;

public class Map<K, V> {

    ArrayList<MapNode<K, V>> buckets;

    /* total number of elements -
    * this is needed because we are storing elements in linked list and not in arraylist */
    int size;

    /* number of filled locations -
    * we will be initializing our arraylist with null so cannot use .size() method
    * */
    int numBuckets;


    /**
     * Map implemented using arraylist
     * Initialized with 5 buckets with null
     * */
    public Map() {
        numBuckets = 5;
        size = 0;
        buckets = new ArrayList<>(numBuckets);
        for(int i = 0; i < numBuckets; i++) {
            buckets.add(null);
        }
    }

    /** Load factor is the number of elements divided by number of buckets (size of arraylist) */
    public double loadFactor() {

        return (1.0 * size) / numBuckets;
    }

    /* rehash function */
    private void rehash() {
        System.out.println("Rehashing: buckets " + numBuckets + " size " + size);
        ArrayList<MapNode<K, V>> temp = buckets;
        buckets = new ArrayList<>();
        for(int i = 0; i < 2*numBuckets; i++) {
            buckets.add(null);
        }
        size = 0;
        numBuckets = 2*numBuckets;

        // now traverse to each node and again insert it
        for(int i = 0; i < temp.size(); i++) {
            MapNode<K, V> head = temp.get(i);
            while(head != null) {
                K key = head.key;
                V value = head.value;
                insert(key, value);
                head = head.next;
            }
        }
    }

    /* hash function */
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    /**
     * Insert methods which does not return anything
     * */
    public void insert(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);

        // traverse head for checking if key exists. If it does then update value
        while(head != null) {
            if(head.key.equals(key)) {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // doesn't contain key - then create key and insert at beginning
        head = buckets.get(bucketIndex);
        MapNode<K, V> newElementNode = new MapNode<K, V>(key, value);
        newElementNode.next = head;
        size++;
        buckets.set(bucketIndex, newElementNode);

        /* check load factor */
        double loadFactor = (1.0 * size) / numBuckets;
        if(loadFactor > 0.7) {
            rehash();
        }
    }


    /** Size function */
    public int size() {
        return size;
    }

    /** RemoveKey - removes a node for given key and return it if found otherwise return null
     * */
    public V removeKey(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);
        MapNode<K, V> prev = null;

        V removeData;
        while(head != null) {
            if(head.key.equals(key)) {
                size--;
                if(prev == null) {
                    buckets.set(bucketIndex, head.next);
                } else {
                    prev.next = head.next;
                }
                return head.value;
            }
            prev = head;
            head = head.next;
        }

        return null;
    }

    /** getValue - get value for a key */
    public V getValue(K key) {
        int bucketIndex = getBucketIndex(key);
        MapNode<K, V> head = buckets.get(bucketIndex);

        while(head != null) {
            if(head.key.equals(key)) {
                return head.value;
            }
            head = head.next;
        }
        return null;
    }
}
