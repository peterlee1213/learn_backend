package _7_generics;

/**
 * 泛型/extends通配符
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265105899616928
 */
public class UpperWildCard_5 {

	public static void main(String[] args) {
		// Pair<Number>和Pair<Integer>没有继承关系不能相互转型是有问题的，如下例所示
		PairHere<Integer> p = new PairHere<>(123, 456);
		int n = add(p); // 报错: The method add(PairHere<Number>) in the type UpperWildCard is not
						// applicable for the arguments (PairHere<Integer>)
		System.out.println(n);
		int n1 = rectifiedAdd(p);
		System.out.println(n1);
	}

	// 修正之后的add函数
	// ? extends Number表示Number以及Number的子类，这就可实现向上转型,这种写法也叫上界通配符，即把泛型类型T的上界限定在Number
	public static int rectifiedAdd(PairHere<? extends Number> p) {
		Number first = p.getFirst();
		Number last = p.getLast();
		// Number以及Number的子类可安全地赋值给Number类型及其父类,但是不能赋值给Integer或Double,因为强制转型可能不成功
		// Integer f = p.getFirst(); // Type mismatch: cannot convert from capture#3-of
		// ? extends Number to Integer
		return first.intValue() + last.intValue();
	}

	public static void set(PairHere<? extends Number> p) {
		Integer a = 100;
		// 设置不过去,因为实际上的p可能是Double或者Long类型,强制转型可能会失败
		// extends通配符不能用来设置值,只能用来获取值然后赋值给extends类型及其父类型
		p.setFirst(a);
	}

	// 有问题的add函数
	public static int add(PairHere<Number> p) {
		Number first = p.getFirst();
		Number last = p.getLast();
		return first.intValue() + last.intValue();
	}

}

class PairHere<T extends Number> {
	private T first;
	private T last;

	public PairHere(T first, T last) {
		this.first = first;
		this.last = last;
	}

	public T getFirst() {
		return first;
	}

	public T getLast() {
		return last;
	}
}

class PairHereChild extends PairHere<Integer> {
	PairHereChild(Integer f, Integer l) {
		super(f, l);
	}
}