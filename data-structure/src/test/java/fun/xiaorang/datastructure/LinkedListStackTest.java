package fun.xiaorang.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 19:54
 */
class LinkedListStackTest {
  @Test
  public void test() {
    LinkedListStack<Integer> stack = new LinkedListStack<>();
    stack.push(1);
    stack.push(3);
    stack.push(2);
    stack.push(5);
    stack.push(4);
    Assertions.assertArrayEquals(new Integer[]{1, 3, 2, 5, 4}, stack.toArray());
    Assertions.assertEquals(4, stack.peek());
    Assertions.assertEquals(4, stack.pop());
    Assertions.assertEquals(5, stack.peek());
    Assertions.assertEquals(4, stack.size());
    stack.pop();
    stack.pop();
    stack.pop();
    stack.pop();
    Assertions.assertTrue(stack.isEmpty());
  }
}