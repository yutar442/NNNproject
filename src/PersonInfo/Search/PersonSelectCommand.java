package PersonInfo.Search;
import java.util.List;
import java.util.Scanner;
import com.naver.Actions;
import com.naver.PersonInfo;
import PersonInfo.PersonInformation;


public class PersonSelectCommand extends PersonInformation {
	
	public void action2(Scanner sc) {
	      Actions info = new Actions();
	      List<PersonInfo> list = info.selectAll();
	      for(int i = 0; i<list.size(); i++) {
	         System.out.println(list.get(i));
	}
	}
}
