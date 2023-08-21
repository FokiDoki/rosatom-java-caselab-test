public class Main {

    public static void main(String[] args) {
        swap(5, 10);
        swap(10, 5);
        swap(0, 1);
        swap(1, 0);
        swap(1, 1);
        swap(-1, 1);
        swap(-10, -15);
        swap(10, -15);
    }

    public static void swap(int a, int b){
        a += b;
        b = a - b;
        a -= b;
        System.out.println("a = " + a + " b = " + b);
    }
}
