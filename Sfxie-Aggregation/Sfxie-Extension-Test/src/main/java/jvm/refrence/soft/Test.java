package jvm.refrence.soft;

public class Test {

	
	public static void main(String[] args) {
		Employee em1 = EmployeeCache.getInstance().getEmployee("1111");
		Employee em2 = EmployeeCache.getInstance().getEmployee("222");
		EmployeeCache.getInstance().clearCache();
		Employee em3 = EmployeeCache.getInstance().getEmployee("1111");
		System.out.println(1);
	}
}
