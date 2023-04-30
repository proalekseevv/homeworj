public class ValidatorService {
    private static final String ALLOWED_CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ_0123456789";

    private ValidatorService() {

    }

    public static boolean validate(String login, String password, String confirmPassword){
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }



    private static void check(String login, String password, String confirmPassword)
            throws WrongPasswordException, WrongLoginException{

        if(login.length() > 20) {
        throw new WrongLoginException("Длинна логина должна быть меньше или равна 20");

        }
        if(password.length() >= 20) {
            throw new WrongPasswordException("Длинна пароля должна быть меньше или равна 20");

        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }
        way1(login, true);
        way1(password, false);
    }

    private static void way1(String string, boolean login)
            throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < string.length(); i++) {
            if (!ALLOWED_CHARACTERS.contains(String.valueOf(string.charAt(i)))) {
                if (login) {
                    throw new WrongLoginException("Символ " + string.charAt(i) + " невалидный");
                } else {
                    throw new WrongPasswordException("Символ " + string.charAt(i) + " невалидный");
                }


            }

        }
    }


    private static void way2(String string, boolean login)
            throws WrongLoginException, WrongPasswordException {
            if (!string.matches("^\\w + $")) {
                if (login) {
                    throw new WrongLoginException("В логине есть невалидный символ!");
                } else {
                    throw new WrongPasswordException("В логине есть невалидный символ!");
                }

            }
        }




}
