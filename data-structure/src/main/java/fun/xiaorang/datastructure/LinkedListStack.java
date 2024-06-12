package fun.xiaorang.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 19:37
 */
public class LinkedListStack<E> {
  /**
   * 栈的长度
   */
  private int size = 0;
  /**
   * 栈顶指针
   */
  private ListNode<E> top;

  /**
   * 获取栈的长度
   *
   * @return 栈的长度
   */
  public int size() {
    return size;
  }

  /**
   * 判断栈是否为空
   *
   * @return true 栈为空，false 栈不为空
   */
  public boolean isEmpty() {
    return size() == 0;
  }

  /**
   * 入栈操作，将元素压入栈中
   *
   * @param element 待压入的元素
   */
  public void push(E element) {
    // 创建新节点
    ListNode<E> newNode = new ListNode<>(element);
    // 新节点的 next 指针指向栈顶
    newNode.next = top;
    // 栈顶指针指向新节点
    top = newNode;
    // 栈的长度加一
    size++;
  }

  /**
   * 出栈操作，弹出栈顶元素
   *
   * @return 弹出的栈顶元素
   */
  public E pop() {
    // 获取栈顶元素
    E num = peek();
    // 栈顶指针指向栈顶的下一个节点，即将栈顶元素的下一个元素作为新的栈顶
    top = top.next;
    // 栈的长度减一
    size--;
    // 返回栈顶元素
    return num;
  }

  /**
   * 获取栈顶元素
   *
   * @return 栈顶元素
   */
  public E peek() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    return top.value;
  }

  /**
   * 将栈中的元素转化为数组
   *
   * @return 栈中的元素组成的数组
   */
  public Object[] toArray() {
    ListNode<E> curr = top;
    Object[] res = new Object[size()];
    for (int i = size() - 1; i >= 0; i--) {
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
