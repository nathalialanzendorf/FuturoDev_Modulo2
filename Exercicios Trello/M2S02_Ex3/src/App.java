public class App {

    public static void main(String[] args) throws Exception {
       double grade[] = { 10, 8.5, 10, 9.1, 10, 8, 10, 1.2, 10, 8};
        double sumGrade = 0;
        double result = 0;

        for (int i = 0; i < grade.length; i++) {
            sumGrade += grade[i];
        }
        result = sumGrade / 10;

       System.out.println("Média: " + result);
    }
}