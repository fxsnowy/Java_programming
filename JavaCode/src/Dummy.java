import cs61b.homework4.*;


class B{
	
	
}

class A extends B{
	A(){
	
	}
}

public class Dummy {
	

    public static void main(String[] args) {
    	LockDList list = new LockDList();
    	list.insertFront(5);
    	list.insertFront(6);
    	
    	DListNode node = list.front();
    	list.remove(node);
    	
    	LockDListNode d;
    	
	} 
}