public class Main {
    public static void main(String[] args) {
        boolean result = Validator.validate("login_123", "QWERasdf_12", "QWERasdf_12");
        if (result){
            System.out.println("Логин и пароль корректные");
        }else {
            System.out.println("Лолин и/или Пароль некорректный");
        }
    }
}