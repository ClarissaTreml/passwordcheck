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
    @DisplayName("Has valid length")
    public void checkPassword_length(){
        Password pw = new Password();
        assertTrue(pw.checkPassword("pw123!pw"));
    }

    @Test
    @DisplayName("Length too short")
    public void checkPassword_shortlength(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("pw12"));
    }

     @Test
    @DisplayName("Length too long")
    public void checkPassword_longlenght(){
        Password pw = new Password();
        assertFalse(pw.checkPassword("pw123!pw123!pw123!pw123!pw"));
     }

}
