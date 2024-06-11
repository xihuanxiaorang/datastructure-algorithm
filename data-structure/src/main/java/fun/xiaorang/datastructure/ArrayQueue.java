package fun.xiaorang.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 23:44
 */
public class ArrayQueue<E> {
  /**
   * 用于存储队列元素的数组
   */
  private final Object[] elementData;
  /**
   * 队头指针，指向队首元素
   */
  private int front;
  /**
   * 队列的长度
   */
  private int size;

  public ArrayQueue() {
    this(10);
  }

  public ArrayQueue(int capacity) {
    elementData = new Object[capacity];
    front = size = 0;
  }

  /**
   * 获取队列的容量
   *
   * @return 队列的容量
   */
  public int capacity() {
    return elementData.length;
  }

  /**
   * 获取队列的长度
   *
   * @return 队列的长度
   */
  public int size() {
    return size;
  }

  /**
   * 判断队列是否为空
   *
   * @return true：队列为空；false：队列不为空
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * 入队操作，将元素e添加到队列的尾部
   *
   * @param e 入队元素
   */
  public void push(E e) {
    if (size() == capacity()) {
      throw new IllegalStateException("队列已满");
    }
    // 计算队尾指针，指向队尾元素的下一个位置
    // 通过取余操作实现 rear 越过数组尾部后回到头部
    int rear = (front + size) % capacity();
    // 将元素放入队尾
    elementData[rear] = e;
    // 队列长度加 1
    size++;
  }

  /**
   * 出队操作，返回队首元素
   *
   * @return 队首元素
   */
  public E pop() {
    // 获取队首元素
    E top = peek();
    // 队首指针向后移动一位，若越过尾部，则返回到数组头部
    front = (front + 1) % capacity();
    // 队列长度减 1
    size--;
    // 返回队首元素
    return top;
  }

  /**
   * 获取队首元素
   *
   * @return 队首元素
   */
  public E peek() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    return elementData(front);
  }

  /**
   * 将队列中的元素转化为数组
   *
   * @return 队列中的元素组成的数组
   */
  public Object[] toArray() {
    // 仅转换有效长度范围内的列表元素
    Object[] res = new Object[size()];
    // 将有效长度范围内的元素复制到新数组中
    for (int i = 0, j = front; i < size(); i++, j++) {
      res[i] = elementData(j % capacity());
    }
    return res;
  }

  @SuppressWarnings("unchecked")
  E elementData(int index) {
    return (E) elementData[index];
  }
}
