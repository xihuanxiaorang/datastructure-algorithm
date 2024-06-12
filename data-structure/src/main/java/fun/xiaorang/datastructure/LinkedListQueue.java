package fun.xiaorang.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 23:09
 */
public class LinkedListQueue<E> {
  /**
   * 队列的长度
   */
  private int size = 0;
  /**
   * 头指针，指向队列的第一个元素
   */
  private ListNode<E> front;
  /**
   * 尾指针，指向队列的最后一个元素
   */
  private ListNode<E> rear;

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
   * @return true 队列为空，false 队列不为空
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
    ListNode<E> newNode = new ListNode<>(e);
    if (front == null) {
      front = newNode;
    } else {
      rear.next = newNode;
    }
    rear = newNode;
    size++;
  }

  /**
   * 出队操作，删除队首元素并返回
   *
   * @return 队首元素
   */
  public E pop() {
    // 获取队首元素
    E top = peek();
    // 将头指针指向队首元素的下一个节点
    front = front.next;
    // 队列长度减一
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
    return front.value;
  }

  /**
   * 将队列中的元素转化为数组
   *
   * @return 队列中的元素组成的数组
   */
  public Object[] toArray() {
    ListNode<E> curr = front;
    Object[] res = new Object[size()];
    for (int i = 0; i < size(); i++) {
      res[i] = curr.value;
      curr = curr.next;
    }
    return res;
  }

  private static class ListNode<E> {
    /**
     * 节点值
     */
    E value;
    /**
     * 后继节点
     */
    ListNode<E> next;

    /**
     * 构造函数
     *
     * @param value 节点值
     */
    public ListNode(final E value) {
      this.value = value;
    }
  }
}
