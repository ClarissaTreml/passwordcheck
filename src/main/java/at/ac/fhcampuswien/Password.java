package at.ac.fhcampuswien;

import static java.lang.Character.isDigit;

public class Password {

    public boolean checkPassword(String password){
        if(!password_null(password)) return false;
        if(password_length(password)) return true;
        if(password_numbers(password)) return true;
        if(!password_case(password)) return false;
        if(password_specialcharacters(password)) return true;
        if(password_letters(password))return true;
        else return true;
    }

    public boolean password_null(String password){

        if(password == null) {
            return false;
        }
        return true;
    }

    public boolean password_length(String password){

        if(password.length() < 8 || password.length() > 25){
            return false;
        }
        return true;
    }

    public boolean password_numbers(String password){

        int count = 0;

        for(int i = 0; i < password.length(); i++){
            if(isDigit(password.charAt(i))){
                count++;
            }
            else if (isDigit(password.charAt(i)) == isDigit(password.charAt(i+1)) == isDigit(password.charAt(i+2))){
                return false;
            }
            else if(isDigit(password.charAt(i)) == isDigit(password.charAt(i)+1) == isDigit(password.charAt(i)+2)){
                return false;
            }
        }
        if(count == 0){
           return false;
        }
        return true;
    }

    public boolean password_letters(String password){
        if(password.matches(".*[A-Z].*[a-z].*")){
            return true;
        }return false;
    }


    public boolean password_case(String password){

        String lowercase = password.toLowerCase();
        String uppercase = password.toUpperCase();

        if(password.equals(lowercase)){
            return false;
        }
        else if(password.equals(uppercase)){
            return false;
        }
        return true;
    }

    public boolean password_specialcharacters(String password){

        char [] passwordArray = password.toCharArray();
        char [] specialcharacters = {'(',')','#','$','?','!','%','/','@'};
        int count = 0;

        for(int i = 0; i <= passwordArray[i]; i++){
            for(int j = 0; j <= specialcharacters[j]; j++){
                if(passwordArray[i] == specialcharacters[j]){
                    count++;
                }
            }
        }

        if(count == 0){
            return false;
        }
        return true;
    }

}
