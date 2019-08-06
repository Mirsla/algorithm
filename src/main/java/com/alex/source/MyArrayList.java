package com.alex.source;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

/**
 * ArrayList 源码解读，手写一个造轮子的ArrayList
 *
 * 这个ArrayList里面可能不会有ArrayList里面那么多的功能，只是实现最基础最简单的功能代码
 *
 * 1、 先就实现List接口，看一下AbstractList<E>这个抽象类 有什么其他的作用，因为在AbstractList这个类文件下还有一个SubList是继承自AbstractList的
 */
public class MyArrayList<E> extends AbstractList<E> implements List<E> {

    /**
     * ArrayList默认初始大小，10
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 这个是ArrayList继承自AbstractList中的字段， 用于记录List的操作数，用于迭代器使用，在并发的情况下快速抛出异常ConcurrentModificationExceptions，用于快速故障
     * 如果在子类中不需要进行这样的处理，那么可以不管这个字段。
     * @return
     */
    // protected transient int modCount = 0;

    /**
     * 一个为空的共享数组，
     *
     * TODO 目前还不知道有啥用
     */
    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 用于默认大小的空数据，用这个鱼EMPTY_ELEMENTDATA 区分开，以便知道在添加第一元素的时候数组应该膨胀多少
     */
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    /**
     * 用于存储数组的数据缓冲区，ArrayList的容量是这个数组的长度。添加第一个元素的时候，并且在elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA 会扩容到默认容量DEFAULT_CAPACITY
     */
    transient Object[] elementData;

    /**
     * 当前数组的大小（使用了的大小，添加了多少元素）;
     */
    private int size;

    /**
     * ArrayList中的数组最大长度为Integer.MAX_VALUE - 8;
     *
     * 为什么ArrayList的最大值是2^31?
     * 数组也是一个对象，在数组对象中，需要额外的空间存储对象的一些信息比如，数组大小，标志信息等，需要8bytes，所以，数组的最大值就行Integer.MAX_VALUE - 8;
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 默认构造函数，就是一个长度为0的空数组
     */
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 带有初始容量的构造函数。
     *      1、initialCapacity > 0； 返回一个指定大小的数组
     *      2、initialCapacity == 0; 将elementData直接赋值为EMPTY_ELEMENTDATA;
     *
     * @param initialCapacity 初始容量
     */
    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    initialCapacity);
        }
    }

    /**
     *  传入进来的集合长度为0的时候给一个空的数组
     *
     * @param c 传入进来的集合
     */
    public MyArrayList(Collection<? extends E> c) {
        elementData = c.toArray();  // 这个方法就是调用的传入进来的集合实现的toArray方法。
        if ((size = elementData.length) != 0) {
            // c.toArray might (incorrectly) not return Object[] (see 6260652)
            if (elementData.getClass() != Object[].class)  // 如果返回回来的不是一个Object[].class 重新copy?
                elementData = Arrays.copyOf(elementData, size, Object[].class);
        } else {
            this.elementData = EMPTY_ELEMENTDATA;
        }
    }

    /**
     * 添加元素
     *      -- 添加元素的时候是先进行扩容然后在进行添加。
     * @param e 需要添加到数组中的元素
     * @return 是否添加成功
     */
    public boolean add(E e) {
        ensureCapacityInternal(size+1);
        elementData[size++] = e;
        return true;
    }

    /**
     * 确定 数组缓存区的大小，初始化的时候采用默认大小
     * @param minCapacity
     */
    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    /**
     * 增加操作数，并调用grow方法执行扩容。
     * @param minCapacity
     */
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }

    /**
     * 计算容量
     * @param elementData 数组缓冲区
     * @param minCapacity 指定的最小容量
     * @return 最小容量 -- 在最开始初始化的时候是返回的ArrayList的默认大小
     */
    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    /**
     * toArray方法是Collection（接口）中定义的方法， 在ArrayList中的实现是调用Arrays.copyOf进行复制。
     * @return
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * 返回指定位置的元素
     * @param index 下标
     */
    E elementData(int index) {
        return (E) elementData[index];
    }

    /**
     * 扩容方法
     * @param minCapacity TODO 此处的minCapacity有什么意思？ 就是size
     */
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        // 新的容量大小为老的容量+老的容量的1/2
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            // 放回一个当前ArrayList能达到的最大容量
            newCapacity = hugeCapacity(minCapacity);
        // 将当前数组复制到一个新的数组中去
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    /**
     * 返回一个最大的ArrayList容量
     * @param minCapacity 传入的容量
     * @return int
     *
     * TODO 有个问题，在这个方法中当minCapacity > MAX_ARRAY_SIZE的时候会返回Integer.MAX_VALUE大小的容量，否则返回MAX_ARRAY_SIZE ArrayList中给定的最大容量。
     * 不是说ArrayList中最大的容量就是MAX_ARRAY_SIZE 吗？
     */
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0)
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }

    /**
     * 获取ArrayList的大小，直接返回size
     * @return size（int） 大小、当前容量
     */
    public int size() {
        return size;
    }

    /**
     * 在指定的位置添加元素,不会将原来位置的元素进行覆盖，会在原来的数组上将指定下标开始的数据往后移动一位，然后将传入进来的数据放入目标位置
     * @param index 添加元素的位置， 下标
     * @param element 需要添加的元素
     */
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        /**
         * add是插入，不是新增，所以在这个地方需要先确定数组的容量，对容量不够的数组进行扩容
         */
        ensureCapacityInternal(size + 1);
        /**
         * 对元素进行复制，此方法是一个系统方法，就是把一个数组中的某一段字节数据放入到另一个数组中
         * 该系统方法定义如下：
         *   public static native void arraycopy(Object src,  int  srcPos,
         *                                         Object dest, int destPos,
         *                                         int length)
         *      src:源数组;
         *      srcPos:源数组要复制的起始位置;
         *      dest:目的数组;
         *      destPos:目的数组放置的起始位置;
         *      length:复制的长度.
         */
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    /**
     *  check下标是否在当前合理的范围类, 传入的index的下标必须在size的范围内
     */
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    /**
     * 继承自AbstractList中的方法（可以说是一样的）
     */
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }

    /**
     * 获取元素
     * @param index 数组下标
     */
    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }

    /**
     *  检查要查询的数组下标是否在给定的区间内，如果不是抛出运行时异常，不检查是否为负数
     * @param index 数组下标
     */
    private void rangeCheck(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    /**
     * 使用此方法之前需要确定当前的ArrayList不为null，否则是会发生空指针异常的
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<E> iterator() {
        return null;
    }

    public <T> T[] toArray(T[] a) {
        return null;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void replaceAll(UnaryOperator<E> operator) {

    }

    public void sort(Comparator<? super E> c) {

    }

    /**
     * 清空数组， 操作数+1, 然后是循环将数组中的每一个位置的元素设置为null，然后将size设置为0；
     */
    public void clear() {
        modCount++;

        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }

    public E set(int index, E element) {
        return null;
    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<E> listIterator() {
        return null;
    }

    public ListIterator<E> listIterator(int index) {
        return null;
    }

    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    public Spliterator<E> spliterator() {
        return null;
    }

    public boolean removeIf(Predicate<? super E> filter) {
        return false;
    }

    public Stream<E> stream() {
        return null;
    }

    public Stream<E> parallelStream() {
        return null;
    }

    public void forEach(Consumer<? super E> action) {

    }
}
