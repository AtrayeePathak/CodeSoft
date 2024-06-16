import java.util.Scanner;
public class studentCalculator {

    public static int totalMarks(int[] marks) {
        int total = 0;
        for (int i = 0; i < marks.length; i++) {

            total = total + marks[i];
        }
        return total;
    }

    public static double averageMarks(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;

    }

    public static void grade(int averagePercentage) {

        if (averagePercentage >= 90) {
            System.out.println("Grade is A");


        } else if (averagePercentage >= 80) {
            System.out.println("Grade is B");


        } else if (averagePercentage >= 70) {
            System.out.println("Grade is C");


        } else if (averagePercentage >= 60) {
            System.out.println("Grade is D");
        } else {
            System.out.println("You Failed....better luck next time!!");
        }
    }

    public static void main(String args[]) {

        //enter the number subjects
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of subjects: ");
        int subjects= sc.nextInt();

        //array to store marks
        int[] marks=new int[subjects];

        //input marks
        for(int i=0;i<subjects;i++){
            System.out.println("Enter the marks of  " +  (i+1)+  ":");
            marks[i]=sc.nextInt();


        }
        //calculate total marks
        int fullMarks= totalMarks(marks);

        //calculate average percentage

        double  averagePercentage= averageMarks(fullMarks,  subjects);



        System.out.println("Total Marks: " + fullMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        grade((int) averagePercentage);







    }
}




