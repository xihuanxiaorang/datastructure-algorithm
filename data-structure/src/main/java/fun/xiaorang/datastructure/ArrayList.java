package fun.xiaorang.datastructure;

/**
 * @author xiaorang
 * @description <p style = " font-weight:bold ; "><p/>
 * @github <a href="https://github.com/xihuanxiaorang/datastructure-algorithm">datastructure-algorithm</a>
 * @Copyright 博客：<a href="https://docs.xiaorang.fun">小让的糖果屋</a>  - show me the code
 * @date 2024/06/11 17:56
 */
public class ArrayList {
  /**
   * 每次列表扩大的倍数
   */
  private final int extendRatio = 2;
  /**
   * 列表容量
   */
  private int capacity = 10;
  /**
   * 数组（存储列表元素）
   */
  private int[] arr;
  /**
   * 列表长度（当前元素数量）
   */
  private int size = 0;

  public ArrayList() {
    arr = new int[capacity];
  }

  /**
   * 获取列表长度（当前元素数量）
   *
   * @return 列表长度（当前元素数量）
   */
  public int size() {
    return size;
  }

  /**
   * 获取列表容量
   *
   * @return 列表容量
   */
  public int capacity() {
    return capacity;
  }

  /**
   * 访问元素
   *
   * @param index 索引
   * @return 元素
   */
  public int get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("索引越界");
    }
    return arr[index];
  }

  /**
   * 更新元素
   *
   * @param index   索引
   * @param element 元素
   */
  public void set(int index, int element) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("索引越界");
    }
    arr[index] = element;
  }

  /**
   * 在列表末尾添加元素
   *
   * @param element 元素
   */
  public void add(int element) {
    // 元素数量超出容量时，触发扩容机制
    if (size == capacity) {
      extendCapacity();
    }
    arr[size++] = element;
  }

  /**
   * 在列表指定位置插入元素
   *
   * @param index   索引
   * @param element 元素
   */
  public void insert(int index, int element) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("索引越界");
    }
    // 元素数量超出容量时，触发扩容机制
    if (size == capacity) {
      extendCapacity();
    }
    // 列表中的元素整体向后移动一位
    System.arraycopy(arr, index, arr, index + 1, size - index);
    // 插入新元素
    arr[index] = element;
    // 列表长度加 1
    size++;
  }

  /**
   * 删除指定位置的元素并返回该元素
   *
   * @param index 索引
   * @return 被删除的元素
   */
  public int remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("索引越界");
    }
    // 记录被删除的元素
    int num = arr[index];
    // 列表中的元素整体向前移动一位
    System.arraycopy(arr, index + 1, arr, index, size - index - 1);
    // 列表长度减 1
    size--;
    // 返回被删除的元素
    return num;
  }

  /**
   * 将列表转换为数组
   *
   * @return 数组
   */
  public int[] toArray() {
    // 仅转换有效长度范围内的列表元素
    int[] res = new int[size];
    // 将有效长度范围内的元素复制到新数组中
    System.arraycopy(arr, 0, res, 0, size);
    return res;
  }

  /**
   * 列表扩容
   */
  private void extendCapacity() {
    // 新数组容量为原数组容量的 extendRatio 倍
    int newCapacity = capacity * extendRatio;
    // 创建一个长度为原数组 extendRatio 倍的新数组
    int[] newArr = new int[newCapacity];
    // 将原数组中的所有元素复制到新数组中
    System.arraycopy(arr, 0, newArr, 0, size);
    // 原数组引用指向新数组
    arr = newArr;
    // 新数组容量设置为原数组容量的 extendRatio 倍
    capacity = newCapacity;
  }
}
