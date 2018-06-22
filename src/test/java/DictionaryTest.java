import com.harium.etyl.i18n.Dictionary;
import com.harium.etyl.i18n.Language;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DictionaryTest {

    public static final String HELLO = "hello";
    private Dictionary dictionary;

    @Before
    public void setUp() {
        dictionary = new Dictionary();
    }

    @Test
    public void testAddSingleWord() {
        String hello = "Olá";
        Language language = Language.PORTUGUESE_BRAZIL;
        dictionary.addWord(language, HELLO, hello);

        Assert.assertEquals(hello, dictionary.getText(language, HELLO));
    }

}
