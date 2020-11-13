package com.atguigu.java;
/*
public class HashMap<K,V> extends AbstractMap<K,V> implements Map<K,V>, Cloneable, Serializable {

    // 默认的初始容量 : 数组大小 : 16
    static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16

    // 最大容量
    static final int MAXIMUM_CAPACITY = 1 << 30;

    // 缺省的加载因子, 控制数组的使用率, 达到这个比值后数组就要扩容
    static final float DEFAULT_LOAD_FACTOR = 0.75f;

    // 链表变成红黑树的入门值.
    static final int TREEIFY_THRESHOLD = 8;

    // 红黑树又转换为链表的入门值
    static final int UNTREEIFY_THRESHOLD = 6;

    // 变树的最小容量? 如果数组的长度大于此值, 才会真的转换红黑树, 如果小于此值, 只是重新扩容.
    static final int MIN_TREEIFY_CAPACITY = 64;

    // 哈希表的基本组成, 结点 : 实现了条目, 说明有键又有值.
    static class Node<K,V> implements Map.Entry<K,V> {
        final int hash; // 键对象的原始哈希码
        final K key; // 键对象
        V value; // 值对象
        Node<K, V> next; // 指针, 用于解决下标冲突时用的链表的指针

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    // 内部哈希表
    transient Node<K,V>[] table; // 创建Map对象时, 内部数组并没有创建.

    // 计数器
    transient int size;

    // 修改次数
    transient int modCount;

    // 数组要扩容的上限.
    int threshold;

    // 当前哈希表的加载因子
    final float loadFactor;

    public HashMap() { // 只确定一件事, 就是加载因子使用缺省的.
        this.loadFactor = DEFAULT_LOAD_FACTOR; // all other fields defaulted
    }

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16); // 为了让原始哈希码更散列
    }

    public V put(K key, V value) {
        return putVal(hash(key), key, value, false, true);
    }

    // 最重要的方法, 放入值
    final V putVal(int hash, K key, V value, boolean onlyIfAbsent, boolean evict) { // hash:5, key : 5, value : "five"
        Node<K,V>[] tab; // 数组, 就是哈希表
        Node<K,V> p; // 目标下标处的老元素
        int n; // 哈希表容量, 数组长度
        int i; // 新的键值对, 条目对象要插入到哈希表中的下标值.

        tab = table; // 哈希表
        n = tab.length; // 数组长度 哈希表容量

        if (tab == null || n == 0) { // 第一次插入元素会进入
            tab = resize(); // 调整容量, 第一次就会调整容量
            n = tab.length;
        }

        i = (n - 1) & hash; // 定位目标下标, 长度-1 & 哈希 => 小于等于长度-1, 和哈希 % 长度 效果完全一样.
        p = tab[i]; // 获取目标的老元素
        if (p == null) { // 最要命语句, 目标位置如果为空, 这是最好最好的情况!!!!!!
            tab[i] = newNode(hash, key, value, null); // 直接插入元素!!!
        } else { // 下标冲突了, 准备链表或红黑树, 50会和2下标冲突
            Node<K,V> e; // 元素, 指向老元素
            K k; // 键对象引用, 老元素中的键对象
            // p是老元素, 老元素的哈希 == 正在插入的键对象的哈希
            // 老元素中的键对象是否 == 正在插入的键对象 或 老元素中的键对象equals正在插入的键对象.
            // 此判断就是判断键是否重复!!!!
            if (p.hash == hash && ((k = p.key) == key || (key != null && key.equals(k)))) { // 如果老键和新键重复!!!
                e = p; // e指向老元素
            } else if (p instanceof TreeNode) { // 判断目标位置是否已经是红黑树
                e = ((TreeNode<K, V>) p).putTreeVal(this, tab, hash, key, value); // 红黑树的插入
            } else { // 键不冲突, 也没有变树, 要做链表了!!!!
                // binCount = 0; binCount统计链表中的元素个数
                for (int binCount = 0; ; ++binCount) {
                    e = p.next; // e指向了p的下一个元素.
                    if (e == null) { // 如果p的next为空, 说明p是链表中的尾结点
                        p.next = newNode(hash, key, value, null); // 尾部链入新结点
                        if (binCount >= TREEIFY_THRESHOLD - 1) {// 判断链表中的元素个数是否已经到了入门值.
                            treeifyBin(tab, hash); // 把链表变成红黑树
                        }
                        break; // 尾部插入完成, 结束.
                    }
                    if (e.hash == hash && ((k = e.key) == key || (key != null && key.equals(k)))) { // 链表中的某键对象和正要插入的键重复
                        break;
                    }
                    p = e; // p指针后移.
                }
            }
            if (e != null) { // existing mapping for key, 如果e不为空, 说明出现了键冲突!!!!!
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

    // 调整容量
    final Node<K,V>[] resize() {
        Node<K,V>[] oldTab = table; // 老表, 第一次老表为null,
        // 第一次老容量 就是 0, 第二次16
        int oldCap = (oldTab == null) ? 0 : oldTab.length;
        // 老上限为0, 第2次是12
        int oldThr = threshold; // 上限
        // 新容量, 新上限
        int newCap, newThr = 0;
        if (oldCap > 0) { // 第一次添加元素时不进入, 第二次扩容时进入
            if (oldCap >= MAXIMUM_CAPACITY) {
                threshold = Integer.MAX_VALUE;
                return oldTab;
            }
            else if ((newCap = oldCap << 1) < MAXIMUM_CAPACITY && oldCap >= DEFAULT_INITIAL_CAPACITY) {
                newThr = oldThr << 1; // double threshold, 容量是*2, 上限也直接*2.
            }
        }
        else if (oldThr > 0) {// initial capacity was placed in threshold 第一次也不会进入
            newCap = oldThr;
        } else {   // 第一次进入             // zero initial threshold signifies using defaults
            newCap = DEFAULT_INITIAL_CAPACITY; // 新容量 : 16
            newThr = (int)(DEFAULT_LOAD_FACTOR * DEFAULT_INITIAL_CAPACITY); // 新上限 : 新容量*缺省因子 = 12
        }
        if (newThr == 0) { // 新上限不为0
            float ft = (float)newCap * loadFactor;
            newThr = (newCap < MAXIMUM_CAPACITY && ft < (float)MAXIMUM_CAPACITY ?
                    (int)ft : Integer.MAX_VALUE);
        }
        // 更新当前对象的上限为12, 第一次
        threshold = newThr;

        // 真正的创建Hash表的代码, 长度是新容量
        @SuppressWarnings({"rawtypes","unchecked"})
        Node<K,V>[] newTab = (Node<K,V>[])new Node[newCap];
        // 更新当前对象中的哈希表为新表
        table = newTab;

        if (oldTab != null) { // 把老表中的所有元素重新散列在新表中.
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

 */