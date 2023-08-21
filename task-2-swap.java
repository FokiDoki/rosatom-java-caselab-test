public class Main {

    public static void main(String[] args) {
        swap(5, 10);   // a = 10, b = 5
        swap(10, 5);   // a = 5, b = 10
        swap(0, 1);    // a = 1, b = 0
        swap(1, 0);    // a = 0, b = 1
        swap(1, 1);    // a = 1, b = 1
        swap(-1, 1);   // a = 1, b = -1
        swap(-10, -15);// a = -15, b = -10
        swap(10, -15); // a = -15, b = 10
    }

    public static void swap(int a, int b){
        a += b;
        b = a - b;
        a -= b;
        System.out.println("a = " + a + " b = " + b);
    }
}
