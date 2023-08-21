public class Main {

    public static void main(String[] args) {
        System.out.println(isPalindrome("test")); // false
        System.out.println(isPalindrome("testtset")); // true
        System.out.println(isPalindrome("qwerrewq")); // true
        System.out.println(isPalindrome("qwerrewqq")); // false
        System.out.println(isPalindrome("")); // false
        System.out.println(isPalindrome("a")); // true
        System.out.println(isPalindrome("aa")); // true
        System.out.println(isPalindrome("а роза упала на лапу Азора")); // true
        System.out.println(isPalindrome("Аргентина манит негра")); // true
        System.out.println(isPalindrome("Sum summus mus")); // true
        System.out.println(isPalindrome("Искать такси")); // true

    }

    public static boolean isPalindrome(String str) {
        if (str.length()==0) return false;
        str = str.toLowerCase();
        str = str.replaceAll("[^а-яёa-z]", "");
        StringBuilder stringBuffer = new StringBuilder(str);
        stringBuffer.reverse();
        return stringBuffer.toString().equals(str);
    }
}
