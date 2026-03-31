public class GenerateException {

    static void generate() {
        String text = null;
        System.out.println(text.length());
    }
    static void handleException() {
        try {
            String text = null;
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Exception Handled");
        }
    }
    public static void main(String[] args) {
        handleException();
    }
}
