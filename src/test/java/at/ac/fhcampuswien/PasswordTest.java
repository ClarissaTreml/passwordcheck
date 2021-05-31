package at.ac.fhcampuswien;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {
    @BeforeAll
    static void init(){}

    @BeforeEach
    void setup(){}

    @Test
    @DisplayName("Has value null")
    public void checkPassword_null(){
        Password pw = new Password();
        assertThrows(IllegalArgumentException.class, () -> pw.checkPassword(null));
        assertFalse(pw.checkPassword(null));
    }

    @Test
    @DisplayName("Is Empty")
    public void checkPassword_empty(){
        Password pw = new Password();
        assertFalse(pw.checkPassword(" "));
    }

    @Test
    @DisplayName("Has valid length")
    public void checkPassword_length(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw134!pw"));
    }

    @Test
    @DisplayName("Length too short")
    public void checkPassword_shortlength(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("Pw123"));
    }

     @Test
    @DisplayName("Length too long")
    public void checkPassword_longlenght(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("Pw123!pw123!pw123!pw123!pw"));
     }

     @Test
    @DisplayName("Has numbers")
    public void checkPassword_numbers(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw112!pw112!"));
     }

     @Test
    @DisplayName("Has no numbers")
    public void checkPassword_nonumbers(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("Password!"));
     }

    @Test
    @DisplayName("Has no consecutive numbers")
    public void checkPassword_noconsecutivenumbers(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw12!pw23!pw34!"));
    }

    @Test
    @DisplayName("Has consecutive numbers")
    public void checkPassword_consecutivenumbers(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("Pw123456789!"));
     }

    @Test
    @DisplayName("Series of numbers less or equal to 3")
    public void checkPassword_noseriesnumber(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw111!pw222!"));
    }

    @Test
    @DisplayName("Series of numbers more than 3")
    public void checkPassword_seriesnumbers(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("Pw1111!pw2222!"));
    }

    @Test
    @DisplayName("Has upper and lower case letters")
    public void checkPassword_caseletters(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw12!pW12!Pw12"));
    }

    @Test
    @DisplayName("Has no upper case letter")
    public void checkPassword_uppercase(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("pw12!pw12!"));
    }

    @Test
    @DisplayName("Has no letters")
    public void checkPassword_noletters(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("112!223?344@"));
    }

    @Test
    @DisplayName("Has no lower case letter")
    public void checkPassword_lowercase(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("PW12!PW12!"));
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

    @Test
    @DisplayName("Has not allowed special character")
    public void checkPassword_forbiddenspecialcharacter(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("Pw112.§"));
    }
}
