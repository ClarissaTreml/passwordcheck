package at.ac.fhcampuswien;

public class Password {

    public boolean checkPassword(String password){

        char [] passwordArray = password.toCharArray();

        if(password.length() < 8 || password.length() > 25){
            if(password == null || password.length() == 0){
                return false;
            }

        }
        return false;


    }
}
