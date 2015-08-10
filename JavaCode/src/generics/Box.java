package generics;

public class Box<T> {

	private T obj;
	
	public T getObj(){
		return obj;
	}
	
	public void setObj(T obj){
		this.obj = obj;
	}
	
	public <U extends Number> void inspect(U u){  //Use generic type U in this method
		System.out.println("T:" + obj.getClass().getName());
		System.out.println("U:" + u.getClass().getName());
	}
}
