package cn.andylhl.data.structure.chapter01.lesson03;

import org.junit.Test;

/***
 * @Title: TestComplex
 * @Description: 测试复数抽象数据类型
 * @author: lhl
 * @date: 2021/3/20 10:17
 */
public class TestComplex {

    // 构造复数
    @Test
    public void testComplex() {
        Complex complex = new Complex(100L, 5L);
        System.out.println(complex);
    }

    // 测试获取实部值
    @Test
    public void testGetReal() {
        Complex complex = new Complex(10L, 10L);
        System.out.println("实部：" + Complex.getReal(complex));
    }

    // 测试获取虚部值
    @Test
    public void testGetImage() {
        Complex complex = new Complex(18L, 38L);
        System.out.println("虚部：" + Complex.getImage(complex));
    }

    // 测试加法
    @Test
    public void testAdd() {
        Complex complex1 = new Complex(200L, 10L);
        Complex complex2 = new Complex(18L, 33L);
        Complex result = Complex.add(complex1, complex2);
        System.out.println(result);
    }

    // 测试减法
    @Test
    public void testSub() {
        Complex complex1 = new Complex(20L, 10L);
        Complex complex2 = new Complex(18L, 33L);
        Complex result = Complex.sub(complex1, complex2);
        System.out.println(result);
    }

}
