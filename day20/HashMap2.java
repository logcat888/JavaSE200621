public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {

    // Ĭ�ϵĳ�ʼ���� : �����С : 16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    // �������
    static final int MAXIMUM_CAPACITY = 1 << 30;

    // ȱʡ�ļ�������, ���������ʹ����, �ﵽ�����ֵ�������Ҫ����
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // �����ɺ����������ֵ.
    static final int TREEIFY_THRESHOLD = 8;

    // �������ת��Ϊ���������ֵ
    static final int UNTREEIFY_THRESHOLD = 6;

    // ��������С����? �������ĳ��ȴ��ڴ�ֵ, �Ż����ת�������, ���С�ڴ�ֵ, ֻ����������.
    static final int MIN_TREEIFY_CAPACITY = 64;

    // ��ϣ��Ļ������, ��� : ʵ������Ŀ, ˵���м�����ֵ.
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash; // �������ԭʼ��ϣ��
        final K key; // ������
        V value; // ֵ����
        Node<K, V> next; // ָ��, ���ڽ���±��ͻʱ�õ������ָ��

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // �ڲ���ϣ��
    transient Node<K,V>[] table; // ����Map����ʱ, �ڲ����鲢û�д���.

    // ������
    transient int size;

    // �޸Ĵ���
    transient int modCount;

    // ����Ҫ���ݵ�����.
    int threshold;

    // ��ǰ��ϣ��ļ�������
    final float loadFactor;

    public HashMap() { // ֻȷ��һ����, ���Ǽ�������ʹ��ȱʡ��.
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); // Ϊ����ԭʼ��ϣ���ɢ��
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    // ����Ҫ�ķ���, ����ֵ
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) { // hash:5, key : 5, value : "five"
        Node<K,V>[] tab; // ����, ���ǹ�ϣ��
        Node<K,V> p; // Ŀ���±괦����Ԫ��
        int n; // ��ϣ������, ���鳤��
        int i; // �µļ�ֵ��, ��Ŀ����Ҫ���뵽��ϣ���е��±�ֵ.

        tab = table; // ��ϣ��
        n = tab.length; // ���鳤�� ��ϣ������

        if (tab == null || n == 0) { // ��һ�β���Ԫ�ػ����
            tab = resize(); // ��������, ��һ�ξͻ��������
            n = tab.length;
        }

        i = (n - 1) & hash; // ��λĿ���±�, ����-1 & ��ϣ => С�ڵ��ڳ���-1, �͹�ϣ % ���� Ч����ȫһ��.
        p = tab[i]; // ��ȡĿ�����Ԫ��
        if (p == null) { // ��Ҫ�����, Ŀ��λ�����Ϊ��, ���������õ����!!!!!!
            tab[i] = newNode(hash, key, value, null); // ֱ�Ӳ���Ԫ��!!!
        } else { // �±��ͻ��, ׼�����������, 50���2�±��ͻ
            Node<K,V> e; // Ԫ��, ָ����Ԫ��
            K k; // ����������, ��Ԫ���еļ�����
            // p����Ԫ��, ��Ԫ�صĹ�ϣ == ���ڲ���ļ�����Ĺ�ϣ
            // ��Ԫ���еļ������Ƿ� == ���ڲ���ļ����� �� ��Ԫ���еļ�����equals���ڲ���ļ�����.
            // ���жϾ����жϼ��Ƿ��ظ�!!!!
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) { // ����ϼ����¼��ظ�!!!
                e = p; // eָ����Ԫ��
            } else if (p instanceof TreeNode) { // �ж�Ŀ��λ���Ƿ��Ѿ��Ǻ����
                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value); // ������Ĳ���
            } else { // ������ͻ, Ҳû�б���, Ҫ��������!!!!
                // binCount = 0; binCountͳ�������е�Ԫ�ظ���
                for (int binCount = 0; ; ++binCount) {
                    e = p.next; // eָ����p����һ��Ԫ��.
                    if (e == null) { // ���p��nextΪ��, ˵��p�������е�β���
                        p.next = newNode(hash, key, value, null); // β�������½��
                        if (binCount >= TREEIFY_THRESHOLD - 1) {// �ж������е�Ԫ�ظ����Ƿ��Ѿ���������ֵ.
                            treeifyBin(tab, hash); // �������ɺ����
                        }
                        break; // β���������, ����.
                    }
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) { // �����е�ĳ���������Ҫ����ļ��ظ�
                        break;
                    }
                    p = e; // pָ�����.
                }
            }
            if (e != null) { // existing mapping for key, ���e��Ϊ��, ˵�������˼���ͻ!!!!!
                V oldValue = e.value;
                if (!onlyIfAbsent || oldValue == null)
                    e.value = value;
                afterNodeAccess(e);
                return oldValue;
            }
        }
        ++modCount;
        if (++size > threshold)
            resize();
        afterNodeInsertion(evict);
        return null;
    }

    // ��������
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table; // �ϱ�, ��һ���ϱ�Ϊnull,
        // ��һ�������� ���� 0, �ڶ���16
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // ������Ϊ0, ��2����12
        int oldThr = threshold; // ����
        // ������, ������
        int newCap, newThr = 0;
        if (oldCap > 0) { // ��һ�����Ԫ��ʱ������, �ڶ�������ʱ����
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThr << 1; // double threshold, ������*2, ����Ҳֱ��*2.
            }
        }
        else if (oldThr > 0) {// initial capacity was placed in threshold ��һ��Ҳ�������
            newCap = oldThr;
        } else {   // ��һ�ν���             // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY; // ������ : 16
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); // ������ : ������*ȱʡ���� = 12
        }
        if (newThr == 0) { // �����޲�Ϊ0
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        // ���µ�ǰ���������Ϊ12, ��һ��
        threshold = newThr;

        // �����Ĵ���Hash��Ĵ���, ������������
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        // ���µ�ǰ�����еĹ�ϣ��Ϊ�±�
        table = newTab;

        if (oldTab != null) { // ���ϱ��е�����Ԫ������ɢ�����±���.
            for (int j = 0; j < oldCap; ++j) {
                Node<K,V> e;
                if ((e = oldTab[j]) != null) {
                    oldTab[j] = null;
                    if (e.next == null)
                        newTab[e.hash & (newCap - 1)] = e;
                    else if (e instanceof TreeNode)
                        ((TreeNode<K,V>)e).split(this, newTab, j, oldCap);
                    else { // preserve order
                        Node<K,V> loHead = null, loTail = null;
                        Node<K,V> hiHead = null, hiTail = null;
                        Node<K,V> next;
                        do {
                            next = e.next;
                            if ((e.hash & oldCap) == 0) {
                                if (loTail == null)
                                    loHead = e;
                                else
                                    loTail.next = e;
                                loTail = e;
                            }
                            else {
                                if (hiTail == null)
                                    hiHead = e;
                                else
                                    hiTail.next = e;
                                hiTail = e;
                            }
                        } while ((e = next) != null);
                        if (loTail != null) {
                            loTail.next = null;
                            newTab[j] = loHead;
                        }
                        if (hiTail != null) {
                            hiTail.next = null;
                            newTab[j + oldCap] = hiHead;
                        }
                    }
                }
            }
        }
        return newTab;
    }

}