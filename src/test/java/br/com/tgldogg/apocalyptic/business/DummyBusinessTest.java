package br.com.tgldogg.apocalyptic.business;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.tgldogg.apocalyptic.business.DummyBusiness;

@RunWith(JUnitPlatform.class)
class DummyBusinessTest {

    @Autowired
    private DummyBusiness dummyBusiness;

    @Test
    public void simpleTestCase() {
        assertTrue(dummyBusiness.isStringPalindromeAnagram("abab"));
        assertFalse(dummyBusiness.isStringPalindromeAnagram("abcb"));
    }

}