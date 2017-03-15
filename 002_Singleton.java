// 双重检查锁
public class Singleton {
    private volatile static Singleton unique;
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		if (unique == null) {                          // 检查实例，如果不存在，就进入同步区			
			synchronized(Singleton.class) {            // 只有第一次才彻底执行这里的代码
				if (unique == null) {                  // 进入区块后，再检查一次，如果仍然是null,才创建实例					
					unique = new Singleton();
				}
			}
		}
		return unique;
	}
} 

// 急切实例化
public class Singleton {
    private static Singleton unique = new Singleton();
	
	private Singleton() {}
	
	public static Singleton getInstance() {
		return unique;
	}
} 

// 同步getInstance方法 
public class Singleton {
    private volatile static Singleton unique;
	
	private Singleton() {}
	
	public static synchronized Singleton getInstance() {
		if (unique == null) {                      		
			unique = new Singleton();
		}
		return unique;
	}
} 
