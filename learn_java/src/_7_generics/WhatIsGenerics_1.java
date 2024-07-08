package _7_generics;

import java.util.Arrays;
import java.util.List;

/**
 * 泛型/什么是泛型
 * https://www.liaoxuefeng.com/wiki/1252599548343744/1265102638843296#0
 */
public final class WhatIsGenerics_1 {
	public static void main(String[] args) {
		Person[] ps = new Person[] {
			new Person("Bob",61),
			new Person("Alice", 88),
			new Person("Lily", 75)
		};
		
		Arrays.sort(ps);
		System.out.println(ps);
	}
}

class Person implements Comparable<Person>{
	String name;
	int score;
	Person(String name, int score){
		this.name = name;
		this.score = score;
	}
	
	public int compareTo(Person other) {
		return this.name.compareTo(other.name);
	}
}