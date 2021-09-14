public class Grades
{
   public static void main(String[] args)
 {
   Scanner input = new Scanner(System.in);
   System.out.println("Please enter your name:");
   String studentName = input.nextLine();
   Student info = new Student(studentName);
   double grade = 0;
   while(grade > -1)
   {
   System.out.println("Please enter in your grade or a number less than 0 to exit");
   grade = input.nextDouble();
   info.addExam(grade);
   }
   System.out.println(info.getName() + " has an average of " + info.average());
   System.exit(0);
   }
 }
