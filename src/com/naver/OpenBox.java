package com.naver;

import java.util.List;
import java.util.Scanner;

import kr.co.ca.DoAction;

public class OpenBox implements DoAction {
   Actions info = new Actions();
   List<PersonInfo> list = info.selectAll();
   boolean isTrue = false;

   @Override
   public void action(Scanner sc) {
      System.out.println("ȸ�� ID�� �Է��ϼ���.");
      String id = sc.nextLine();
      
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i).getId().equals(id)) {
            isTrue = true;
         }
      }
      if (isTrue) {
         System.out.println("��ǰ ������ ��й�ȣ�� �Է��ϼ���.");
         int password = sc.nextInt();
         sc.nextLine();
         List<BoxInfo> boxList = info.boxSelectAll();
         for (int i = 0; i < boxList.size(); i++) {
            if (boxList.get(i).getPw() == password) {
            
               System.out.println("��ǰ������ ��й�ȣ �Է� ����");
            } else {
               System.out.println("��ǰ������ ��й�ȣ�� Ʋ�Ƚ��ϴ�.");
            }
         }   
      } else {
         System.out.println("ȸ�� ������ ���� id�Դϴ�.");
      }
      
      
     
   }
}