public class Student
{

   private String studentName;
   private double examSum;
   private double examNumGrades;

   public Student(String name)
   {
   this.studentName = name;
   }

   public String getName()
   {
   return studentName;
   }

   public void addExam(double grade)
   {
   if(grade >= 0)
   {
   examSum += grade;
   examNumGrades++;
   }
   }
   public double average()
   {
   if(examNumGrades > 0)
   {
   return examSum / examNumGrades;
   }
   else{
   return 100;
   }
}
}
