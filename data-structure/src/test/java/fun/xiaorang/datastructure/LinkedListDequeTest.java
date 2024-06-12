package fun.xiaorang.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/12 14:44
 */
class LinkedListDequeTest {
  @Test
  public void test() {
    LinkedListDeque<Integer> deque = new LinkedListDeque<>();
    deque.pushLast(2);
    deque.pushLast(5);
    deque.pushFirst(3);
    deque.pushLast(4);
    deque.pushFirst(1);
    Assertions.assertArrayEquals(new Integer[]{1, 3, 2, 5, 4}, deque.toArray());
    Assertions.assertEquals(1, deque.peekFirst());
    Assertions.assertEquals(4, deque.peekLast());
    Assertions.assertEquals(1, deque.popFirst()); // 3, 2, 5, 4
    Assertions.assertEquals(4, deque.popLast()); // 3, 2, 5
    Assertions.assertEquals(3, deque.size());
    Assertions.assertEquals(3, deque.popFirst()); // 2, 5
    Assertions.assertEquals(2, deque.popFirst()); // 5
    Assertions.assertEquals(5, deque.popLast());
    Assertions.assertTrue(deque.isEmpty());
  }
}