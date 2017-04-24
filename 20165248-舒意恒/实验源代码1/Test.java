class A{
	public void func1(){
		System.out.println("A func1 is calling");
	}
	public void func2(){
		func1();
	}
}
class B extends A{
	public void func1(){//Override the func1() in A
		System.out.println("B func1 is calling");
	}
	public void func3(){
		System.out.println("B func3 is calling");
	}
}

class D extends A{
	public void func1()	{
		System.out.println("D func1 is calling");
	}
}
class Student
{
	String name;
}
class Test{
  public static void callA(A a){
    a.func1();
    a.func2();
	  B b=(B)a;
	  b.func3();
  }
  public static void main(String args[]){
	  int [] i={1,2};
	  Student [] stu=new Student[2];
	  stu[0]=new Student();
		stu[1]=new Student();
    B b=new B();
    A a=b;
    callA(a);
  }
}
