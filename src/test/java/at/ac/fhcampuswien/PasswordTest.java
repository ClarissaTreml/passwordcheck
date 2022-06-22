package at.ac.fhcampuswien;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    @DisplayName("Has value null")
    public void checkPassword_null(){
        Password pw = new Password();
        assertFalse(pw.checkPassword(null));
    }

    @Test
    @DisplayName("Has valid length")
    public void checkPassword_length(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw134!pw"));
    }

     @Test
    @DisplayName("Has numbers")
    public void checkPassword_numbers(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw112!pw112!"));
     }


    @Test
    @DisplayName("Has no consecutive numbers")
    public void checkPassword_noconsecutivenumbers(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw12!pw23!pw34!"));
    }

    @Test
    @DisplayName("Series of numbers less or equal to 3")
    public void checkPassword_noseriesnumber(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw111!pw222!"));
    }

    @Test
    @DisplayName("Has upper and lower case letters")
    public void checkPassword_caseletters(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw12!pW12!Pw12"));
    }

    @Test
    @DisplayName("Has letters")
    public void checkPassword_letters(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("a112!223?344@"));
    }

    @Test
    @DisplayName("Has special character")
    public void checkPassword_specialcharacter(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw112!?%$"));
    }

    @Test
    @DisplayName("Has no special character")
    public void checkPassword_nospecialcharacter(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw112pw223"));
    }

}
