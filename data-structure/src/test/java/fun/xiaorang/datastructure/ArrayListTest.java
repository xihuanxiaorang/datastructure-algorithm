package fun.xiaorang.datastructure;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 18:32
 */
class ArrayListTest {
  @Test
  public void test() {
    ArrayList<Integer> list = new ArrayList<>();
    list.add(1);
    list.add(3);
    list.add(2);
    list.add(5);
    list.add(4);
    Assertions.assertArrayEquals(new Integer[]{1, 3, 2, 5, 4}, list.toArray());
    Assertions.assertEquals(2, list.get(2));
    Assertions.assertEquals(5, list.remove(3)); // 1, 3, 2, 4
    Assertions.assertEquals(4, list.size());
    list.set(3, 6);
    Assertions.assertEquals(6, list.get(3)); // 1, 3, 2, 6
    list.insert(4, 7); // 1, 3, 2, 6, 7
    list.insert(0, 8); // 8, 1, 3, 2, 6, 7
    Assertions.assertArrayEquals(new Integer[]{8, 1, 3, 2, 6, 7}, list.toArray());
  }
}