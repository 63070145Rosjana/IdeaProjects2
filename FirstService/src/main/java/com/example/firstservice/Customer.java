package com.example.firstservice;

public class Customer {
   private String ID;
   private String name;
   private boolean sex;
   private int age;

   public Customer()
   {
      this("",null, "female", 0);

//
   }
   public Customer(String ID, String n, String s, int a)
   {
      this.ID = ID;
      this.name = n;
      this.sex = Check(s);
      this.age = a;
      System.out.println(this.sex);

   }

   public String getID() {
      return ID;
   }

   public void setID(String ID) {
      this.ID = ID;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {

      this.name = name;
   }



   public int getAge() {
      return age;
   }

   public void setAge(int age) {
      if(age >= 0){
         this.age = age;
      }else {
         this.age = 0;
      }
   }


   public Boolean getSex() {
      return sex;
   }
   public void setSex(Boolean s) {
      this.sex = s;
   }
   public boolean Check(String s){
      if(s.equals("male") || s.equals("Male")){
         return true;

      }
      else if (s.equals("female") || s.equals("Female")){
         return false;

      }

      return false;
   }




}
