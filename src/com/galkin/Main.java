package com.galkin;

public class Main {

    public static void main(String[] args) {
      HashMap hashMap = new HashMap();
      long j = 0l;
      for(int i = -10; i< 40; i++){
          hashMap.put(i, j);
          if(hashMap.get(i) == j){
              System.out.println("Ok");
          }
          j++;
      }
    }
}
