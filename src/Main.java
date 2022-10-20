import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "111abc7";
        String password = "pass_123";
        String confirmPassword = "pass_123";
        System.out.println(threeParametersMethod(login, password, confirmPassword));


    }

    public static boolean threeParametersMethod(String login, String password, String confirmPassword) {
        boolean checkLogin;
        boolean checkPassword;
        boolean loginValidator;
        boolean passwordValidator;
        boolean passwordMatch;

        try {
            checkLogin = characterValidator(login);
            checkPassword = characterValidator(password);
            loginValidator = loginValidator(login);
            passwordValidator = passwordValidator(password);
            passwordMatch = passwordMatchValidator(password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return checkLogin && checkPassword && passwordValidator;
    }


    public static boolean characterValidator(String checkWord) {
        if (checkWord == null) {
            throw new NullPointerException("Заданный параметр - null");
        }
        if (checkWord.matches("\\w+")) {
            return true;
        }
        System.out.println("Заданы неверные символы");
        return false;

    }

    public static boolean loginValidator(String login) throws WrongLoginException {
        if (login.length() > 20) {
            throw new WrongLoginException("Слишком длинный логин");
        }
        return true;

    }

    public static boolean passwordValidator(String password) {
        if (password.length() > 19) {
            System.out.println("Слишком длинный пароль");
            return false;
        }
        return true;

    }

    public static boolean passwordMatchValidator(String password, String confirmPassword) throws WrongPasswordException {
        if (password.equals(confirmPassword))
            return true;
        throw new WrongPasswordException("Пароли не совпадают");

    }
}