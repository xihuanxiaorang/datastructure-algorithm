package fun.xiaorang.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 23:30
 */
class LinkedListQueueTest {
  @Test
  public void test() {
    LinkedListQueue<Integer> queue = new LinkedListQueue<>();
    queue.push(1);
    queue.push(3);
    queue.push(2);
    queue.push(5);
    queue.push(4);
    Assertions.assertArrayEquals(new Integer[]{1, 3, 2, 5, 4}, queue.toArray());
    Assertions.assertEquals(1, queue.peek());
    Assertions.assertEquals(1, queue.pop());
    Assertions.assertEquals(3, queue.peek());
    Assertions.assertEquals(4, queue.size());
    queue.pop();
    queue.pop();
    queue.pop();
    queue.pop();
    Assertions.assertTrue(queue.isEmpty());
  }
}