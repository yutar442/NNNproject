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
      System.out.println("회원 ID를 입력하세요.");
      String id = sc.nextLine();
      
      for (int i = 0; i < list.size(); i++) {
         if (list.get(i).getId().equals(id)) {
            isTrue = true;
         }
      }
      if (isTrue) {
         System.out.println("물품 보관함 비밀번호를 입력하세요.");
         int password = sc.nextInt();
         sc.nextLine();
         List<BoxInfo> boxList = info.boxSelectAll();
         for (int i = 0; i < boxList.size(); i++) {
            if (boxList.get(i).getPw() == password) {
            
               System.out.println("물품보관함 비밀번호 입력 성공");
            } else {
               System.out.println("물품보관함 비밀번호가 틀렸습니다.");
            }
         }   
      } else {
         System.out.println("회원 정보에 없는 id입니다.");
      }
      
      
     
   }
}