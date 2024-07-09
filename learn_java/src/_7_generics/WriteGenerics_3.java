package _7_generics;

/**
 * 泛型/编写泛型
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265105853480864#0
 */
public class WriteGenerics_3 {
	public static void main(String[] args) {
		//泛型的一般用法
		Pair<String> p = new Pair<String>("firstname","lastname");
		//静态方法中的泛型
		Pair<String> p1 = Pair.create("123", "345");
		//多个泛型
		MultiGenerics<String, Integer> m = new MultiGenerics<>("123",345);
	}
}

class Pair<T>{
	private T first;
	private T last;
	public Pair(T first,T last) {
		this.first = first;
		this.last = last;
	}
	
	public T getFirst() {
		return this.first;
	}
	
	public T getLast() {
		return this.last;
	}
	
	public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}

class MultiGenerics<T,K>{
	private T first;
	private K last;
	
	public MultiGenerics(T first, K last) {
		this.first = first;
		this.last = last;
	}
	
	public T getFirst() {
		return this.first;
	}
	
	public K getLast() {
		return this.last;
	}
}
