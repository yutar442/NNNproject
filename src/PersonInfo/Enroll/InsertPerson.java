package PersonInfo.Enroll;
import java.util.Scanner;
import com.naver.Actions;
import com.naver.PersonInfo;
import PersonInfo.PersonInformation;



public class InsertPerson extends PersonInformation{

	
	public void action1(Scanner sc) {
		   System.out.println("���̵� �Է��ϼ���.");
		      String id = sc.nextLine();
		      
		      System.out.println("�̸��� �Է��ϼ���.");
		      String name = sc.nextLine();
		      
		      System.out.println("�ڵ��� ��ȣ�� �Է��ϼ���.");
		      String sphoneNum = sc.nextLine();
		      int phoneNum = Integer.parseInt(sphoneNum);
		      
		      PersonInfo ps = new PersonInfo(id, name, phoneNum);
		      Actions action = new Actions();
		      action.insert(ps);

	}

}
