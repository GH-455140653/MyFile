package exam;

public class Test {
    public static void main(String[] args) {
        Login login = new Login();
        login.login();
        printStar();
    }

    public static void printStar() {
        for (int i = 0; i < 50; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
