package com.galkin;

import java.util.Objects;

public class HashMap {
     private Node[] table;
     private int capacity = 16;
     private int size;

     public HashMap(){
         table =  new Node[capacity];
     }

     public void put(int key, long value){
         int position = findPosition(key);
         if(position != -1){
             table[position].value = value;
             return;
         }
         size++;
         if(capacity == size){
             increaseHashTable();
         }
         position  = getEmptyPosition(key);
         Node newNode = new Node(key, value);
         table[position] = newNode;
     }

     public Long get(int key){
         int position = findPosition(key);
         if(position == -1){
             return null;
         }

         return table[position].value;
     }

     private int getEmptyPosition(int key) {
         int position = 0;
         int index = 0;
         while (index < capacity) {
             position = (key + index * index) % capacity;
             if (position < 0) {
                 position = capacity + position;
             }

             if (Objects.isNull(table[position])) {
                 break;
             }

             index++;
         }

         return position;
     }

     private int findPosition(int key){
         int position = 0;
         int index = 0;
         boolean isFound = false;
         while (index < capacity) {
             position = (key + index * index) % capacity;
             if (position < 0) {
                 position = capacity + position;
             }

             if(table[position] == null){
                 break;
             }

             if(table[position].key == key){
                 isFound = true;
                 break;
             }
             index++;
         }

         if(isFound){
             return position;
         }

         return -1;
     }

     private void increaseHashTable(){
         capacity = capacity * 2;
         size = 0;
         Node[] oldTable = table;
         table = new Node[capacity];
         for(Node element: oldTable){
             put(element.key, element.value);
         }
     }


     private static class Node{
         public int key;
         public long value;

         public Node(int key, long value){
             this.key = key;
             this.value = value;
         }
     }
}
