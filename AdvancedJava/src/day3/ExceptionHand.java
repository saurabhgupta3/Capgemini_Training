package day3;

import java.util.HashMap;


class User extends HashMap<String, String> {
	@Override
	public String put(String key, String val) {
		if(this.containsKey(key)) {
			throw new RuntimeException("usernameExistsException");
		}
		return super.put(key, val);
	}
}

public class ExceptionHand {
	public static void main(String[] args){
		User obj = new User();
		obj.put("Saurabh", "abc123");
		obj.put("Ayush", "123abc");
		obj.put("Saurabh", "abc321");
	}
}
