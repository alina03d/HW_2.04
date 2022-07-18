public class Validator {

    private static final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz_0123456789";

    private Validator(){
    }
    public static boolean validate(String login,String password, String confirmPassword){
        try {
            check(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    private static void check(String login,
                              String password,
                              String confirmPassword) throws WrongLoginException,WrongPasswordException{
        if (login==null || login.length()>20){
            throw new WrongLoginException("Длина логина должна быть иеньше или равна 20!");
        }
        if (password==null || !password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
        if ( password.length()>=20){
            throw new WrongPasswordException("Длина пароля должна быть иеньше 20!");
        }
        checkCharacters(login,"Логин");
        checkCharacters(password,"Пароль");
    }
    private static void checkCharacters(String c, String a) throws WrongLoginException{
        for (int i = 0; i < c.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(c.charAt(i)))){
                throw new WrongLoginException(String.format("%s содержит неверный символ %c!", a, c.charAt(i)));
            }
        }
    }
}
