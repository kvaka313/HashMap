package com.galkin;

public class HashMap {
     private Node[] table;
     private int capacity =16;

     public HashMap(){
         table =  new Node[capacity];
     }

     private static class Node{
         public int key;
         public long value;
     }
}
