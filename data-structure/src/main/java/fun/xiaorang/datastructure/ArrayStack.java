package fun.xiaorang.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 22:07
 */
public class ArrayStack<E> {
  private final ArrayList<E> stack;

  public ArrayStack() {
    // 初始化一个空的列表（动态数组）作为栈
    stack = new ArrayList<>();
  }

  /**
   * 获取栈的长度
   *
   * @return 栈的长度
   */
  public int size() {
    return stack.size();
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
    stack.add(element);
  }

  /**
   * 出栈操作，弹出栈顶元素
   *
   * @return 弹出的栈顶元素
   */
  public E pop() {
    if (isEmpty()) {
      throw new IndexOutOfBoundsException();
    }
    return stack.remove(size() - 1);
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
    return stack.get(size() - 1);
  }

  /**
   * 将栈中的元素转化为数组
   *
   * @return 栈中的元素组成的数组
   */
  public Object[] toArray() {
    return stack.toArray();
  }
}
