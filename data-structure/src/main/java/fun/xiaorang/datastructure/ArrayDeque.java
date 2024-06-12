package fun.xiaorang.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/12 15:15
 */
public class ArrayDeque<E> {
  /**
   * 用于存储队列元素的数组
   */
  private final Object[] elementData;
  /**
   * 队列的长度
   */
  private int size;
  /**
   * 队头指针，指向队首元素
   */
  private int front;

  public ArrayDeque() {
    this(10);
  }

  public ArrayDeque(int capacity) {
    this.elementData = new Object[capacity];
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
    return size == 0;
  }

  /**
   * 队首入队操作
   *
   * @param e 入队元素
   */
  public void pushFirst(final E e) {
    if (size() == capacity()) {
      throw new IllegalStateException("队列已满");
    }
    // 队首指针向左移动一位
    // 通过取余操作实现 front 越过数组头部后回到尾部
    front = index(front - 1);
    // 将元素添加至队首
    elementData[front] = e;
    // 队列长度加1
    size++;
  }

  /**
   * 队尾入队操作
   *
   * @param e 入队元素
   */
  public void pushLast(final E e) {
    if (size() == capacity()) {
      throw new IllegalStateException("队列已满");
    }
    // 计算队尾指针，指向队尾元素的下一个位置
    // 通过取余操作实现 rear 越过数组尾部后回到头部
    int rear = index(front + size);
    // 将元素添加至队尾
    elementData[rear] = e;
    // 队列长度加1
    size++;
  }

  /**
   * 队首出队操作
   *
   * @return 队首元素
   */
  public E popFirst() {
    // 获取队首元素
    E e = peekFirst();
    // 队首指针向右移动一位
    front = index(front + 1);
    // 队列长度减1
    size--;
    return e;
  }

  /**
   * 队尾出队操作
   *
   * @return 队尾元素
   */
  public E popLast() {
    // 获取队尾元素
    E e = peekLast();
    // 队列长度减1
    size--;
    return e;
  }

  /**
   * 获取队首元素
   *
   * @return 队首元素
   */
  public E peekFirst() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    return elementData(front);
  }

  /**
   * 获取队尾元素
   *
   * @return 队尾元素
   */
  public E peekLast() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    // 计算尾元素索引
    int last = index(front + size - 1);
    return elementData(last);
  }

  /**
   * 将队列中的元素转化为数组
   *
   * @return 队列中的元素组成的数组
   */
  public Object[] toArray() {
    // 仅转换有效长度范围内的列表元素
    Object[] res = new Object[size];
    // 将有效长度范围内的元素复制到新数组中
    for (int i = 0, j = front; i < size; i++, j++) {
      res[i] = elementData(index(j));
    }
    return res;
  }

  @SuppressWarnings("unchecked")
  E elementData(int index) {
    return (E) elementData[index];
  }

  private int index(int index) {
    // 通过取余操作实现数组首尾相连
    // 当 index 越过数组尾部后，回到头部
    // 当 index 越过数组头部后，回到尾部
    return (index + capacity()) % capacity();
  }
}
