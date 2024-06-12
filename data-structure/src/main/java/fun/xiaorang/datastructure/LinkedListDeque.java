package fun.xiaorang.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/12 12:42
 */
public class LinkedListDeque<E> {
  /**
   * 队列的长度
   */
  private int size = 0;
  /**
   * 头节点
   */
  private ListNode<E> front;
  /**
   * 尾节点
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
   * 队首入队操作
   *
   * @param e 入队元素
   */
  public void pushFirst(final E e) {
    push(e, true);
  }

  /**
   * 队尾入队操作
   *
   * @param e 入队元素
   */
  public void pushLast(final E e) {
    push(e, false);
  }

  /**
   * 队首出队操作
   *
   * @return 队首元素
   */
  public E popFirst() {
    return pop(true);
  }

  /**
   * 队尾出队操作
   *
   * @return 队尾元素
   */
  public E popLast() {
    return pop(false);
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
    return front.value;
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
    return rear.value;
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

  /**
   * 出队操作
   *
   * @param isFront 出队位置，true 队首，false 队尾
   * @return 出队元素
   */
  private E pop(final boolean isFront) {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    E value;
    if (isFront) {
      // 队首出队操作
      // 保存队首元素的值
      value = front.value;
      // 获取队首节点的后继节点
      ListNode<E> next = front.next;
      if (next != null) {
        // 将后继节点的前驱节点指向null，让队首节点与链表断开
        next.prev = null;
      }
      // 更新头节点，让其指向后继节点
      front = next;
    } else {
      // 队尾出队操作
      // 保存队尾元素的值
      value = rear.value;
      // 获取队尾节点的前驱节点
      ListNode<E> prev = rear.prev;
      if (prev != null) {
        // 将前驱节点的后继节点指向null，让其与链表断开
        prev.next = null;
      }
      // 更新尾节点，让其指向前驱节点
      rear = prev;
    }
    // 队列长度减1
    size--;
    return value;
  }

  /**
   * 入队操作
   *
   * @param e       入队元素
   * @param isFront 入队位置，true 队首，false 队尾
   */
  private void push(final E e, final boolean isFront) {
    // 创建新节点
    ListNode<E> newNode = new ListNode<>(e);
    // 如果队列为空，则头节点和尾节点都指向新节点
    if (isEmpty()) {
      front = rear = newNode;
    } else if (isFront) {
      // 队首入队操作，将新节点添加到链表的头部
      // 头节点的前驱节点指向新节点
      front.prev = newNode;
      // 新节点的后继节点指向头节点
      newNode.next = front;
      // 更新头节点，让其指向新节点
      front = newNode;
    } else {
      // 队尾入队操作，将新节点添加到链表的尾部
      // 尾节点的后继节点指向新节点
      rear.next = newNode;
      // 新节点的前驱节点指向尾节点
      newNode.prev = rear;
      // 更新尾节点，让其指向新节点
      rear = newNode;
    }
    // 队列长度加1
    size++;
  }

  private static class ListNode<E> {
    /**
     * 节点值
     */
    E value;
    /**
     * 前驱节点
     */
    ListNode<E> prev;
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
