package com.aaron.design.clone;

public class Student implements Cloneable {
    private String name;
	private int age;

	public Student() {
	}

	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// 重写克隆方法子列才可以调用
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}