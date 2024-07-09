package _7_generics;

/**
 * 泛型/擦拭法（泛型的局限）
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265104600263968
 */
public class TypeErasure_4 {

	
	//Java的泛型实现方法是擦拭法，即虚拟机对泛型一无所知，所有工作都是编译器做的
	//所有泛型都会被编译器编译为Object,然后根据泛型具体类型为我们进行强制转型
	public static void main(String[] args) {
		//局限1: <T>不能是基本类型，因为基本类型无法转换为Object
		//Pair<int> p = new Pair<>(1,2);	//compile error
		
		//局限2: 无法取得带泛型的Class
		Pair<String> p1 = new Pair<>("peter","lee");
		Pair<Integer> p2 = new Pair<>(123,345);
		Class c1 = p1.getClass();
		Class c2 = p2.getClass();
		System.out.println(c1 == c2); //true
		
		//局限3: 无法用instanceof判断带泛型的类型,会直接编译报错
		Pair<Integer> p3 = new Pair<>(123,234);
		if(p3 instanceof Pair<String>) {
			
		}
		
		//局限4: 不能实例化T类型
		
	}

}

//泛型继承--指定泛型具体类型
class IntPair extends Pair<Integer>{
	public IntPair(Integer first, Integer last) {
		super(first,last);
	}
}

//泛型继承--不指定泛型具体类型
class RandomPair<T> extends Pair<T>{
	public RandomPair(T first, T last) {
		super(first,last);
	}
}
