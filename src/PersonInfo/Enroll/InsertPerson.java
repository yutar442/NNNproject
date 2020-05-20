package PersonInfo.Enroll;
import java.util.Scanner;
import com.naver.Actions;
import com.naver.PersonInfo;
import PersonInfo.PersonInformation;



public class InsertPerson extends PersonInformation{

	
	public void action1(Scanner sc) {
		   System.out.println("아이디를 입력하세요.");
		      String id = sc.nextLine();
		      
		      System.out.println("이름을 입력하세요.");
		      String name = sc.nextLine();
		      
		      System.out.println("핸드폰 번호를 입력하세요.");
		      String sphoneNum = sc.nextLine();
		      int phoneNum = Integer.parseInt(sphoneNum);
		      
		      PersonInfo ps = new PersonInfo(id, name, phoneNum);
		      Actions action = new Actions();
		      action.insert(ps);

	}

}
