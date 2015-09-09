package StaticMemberClasses;

import java.util.ArrayList;
import java.util.List;


/*
 * class within interface is automatically 'public static'.
 * 
 */

interface Input{
	
	static class KeyEvent{
		public static final int KEY_DOWN = 0;
		public static final int KEY_UP = 0;
		public int type;
		public int keyCode;
		public int keyChar;
	}
	
	static class TouchEvent{
		public static final int TOUCH_DOWN = 0;
		public static final int TOUCH_UP =0;
		public static final int TOUCH_DRAGGED = 2;
		public int type;
		public int x, y;
		public int pointer;
	}
	
	public boolean isKeyPressed(int keyCode);
	public boolean isTouchDown(int pointer);
	public int getTouchX(int pointer);
	public int getTouchY(int pointer);
	public float getAccelX();
	public float getAccelY();
	public float getAccelZ();
	public List<KeyEvent> getKeyEvents();
	public List<TouchEvent> getTouchEvents(); 
}

interface User {
    public enum Role {
        ADMIN("administrator"),
        EDITOR("editor"),
        VANILLA("regular user");

        private String description;

        private Role(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    public String getName();
    public void setName(String name);
    public Role getRole();
    public void setRole(Role role);
 
}


class Keyboard implements Input{

	@Override
	public boolean isKeyPressed(int keyCode) { return false; }

	@Override
	public boolean isTouchDown(int pointer) { return false; }

	@Override
	public int getTouchX(int pointer) { return 0; }

	@Override
	public int getTouchY(int pointer) { return 0; }

	@Override
	public float getAccelX() { return 0; }

	@Override
	public float getAccelY() { return 0; }

	@Override
	public float getAccelZ() { return 0; }

	@Override
	public List<KeyEvent> getKeyEvents() {
		Input.KeyEvent obj1 = new Input.KeyEvent();
		Input.KeyEvent obj2 = new Input.KeyEvent();
		List<Input.KeyEvent> list = new ArrayList<Input.KeyEvent>();
		list.add(obj1);
		list.add(obj2);
		return list;
	}

	@Override
	public List<TouchEvent> getTouchEvents() {
		TouchEvent obj1 = new TouchEvent();
		TouchEvent obj2 = new TouchEvent();
		List<TouchEvent> list = new ArrayList<TouchEvent>();
		list.add(obj1);
		list.add(obj2);
		return list;
	}

}


public class NestedClassInInterface {
	public static void main(String[] args) {
		Input.TouchEvent t = new Input.TouchEvent();
	}
}