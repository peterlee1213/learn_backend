package _7_generics;

/**
 * 泛型/super通配符
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265105920586976#0
 */
public class SuperWildCard_6 {

	public static void main(String[] args) {
		PairSuper<Number> p1 = new PairSuper<>(12.3, 23.4);
		set(p1, 12, 23);
	}

	// 此super关键字的作用是将泛型约束在Interger及其父类
	// super关键字修饰方法时只能写不能读,与extends关键字恰好相反
	public static void set(PairSuper<? super Integer> p, Integer first, Integer last) {
		p.setFirst(first);
		p.setLast(last);
	}

}

class PairSuper<T> {
	private T first;
	private T last;

	PairSuper(T first, T last) {
		this.first = first;
		this.last = last;
	}

	public T getFirst() {
		return this.first;
	}

	public T getLast() {
		return this.last;
	}

	public void setFirst(T first) {
		this.first = first;
	}

	public void setLast(T last) {
		this.last = last;
	}
}
