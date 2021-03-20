package cn.andylhl.data.structure.chapter01.lesson03;

/***
 * @Title: Complex
 * @Description: 以复数为例，实现该抽象数据类型。课本P9
 * @author: lhl
 * @date: 2021/3/20 10:02
 */
public class Complex {

    // 实部
    private float realPart;

    // 虚部
    private float imagePart;

    public Complex() {}

    // 有参数构造函数
    public Complex(float x, float y) {
        this.realPart = x;
        this.imagePart = y;
    }


    // 返回复数实部值
    public static float getReal (Complex complex) {
        return complex.getRealPart();
    }

    // 返回复数虚部值
    public static float getImage (Complex complex) {
        return complex.getImagePart();
    }

    // 返回两个复数的和
    public static Complex add (Complex complex1, Complex complex2) {
        Complex sum = new Complex();
        sum.setRealPart(complex1.getRealPart() + complex2.getRealPart());
        sum.setImagePart(complex1.getImagePart() + complex2.getImagePart());
        return sum;
    }

    // 返回两个复数的差
    public static Complex sub (Complex complex1, Complex complex2) {
        Complex difference = new Complex();
        difference.setRealPart(complex1.getRealPart() - complex2.getRealPart());
        difference.setImagePart(complex1.getImagePart() - complex2.getImagePart());
        return difference;
    }

    // getter
    public float getRealPart() {
        return realPart;
    }

    // getter
    public float getImagePart() {
        return imagePart;
    }

    // setter
    public void setRealPart(float realPart) {
        this.realPart = realPart;
    }

    // setter
    public void setImagePart(float imagePart) {
        this.imagePart = imagePart;
    }

    @Override
    public String toString() {
        return "Complex{" +
                "realPart=" + realPart +
                ", imagePart=" + imagePart +
                '}';
    }
}
