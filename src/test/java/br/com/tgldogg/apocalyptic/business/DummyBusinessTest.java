package br.com.tgldogg.apocalyptic.business;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DummyBusinessTest {

    @Autowired
    private DummyBusiness dummyBusiness;

    @Test
    public void simpleTestCase() {
        assertTrue(dummyBusiness.isStringPalindromeAnagram("abab"));
        assertFalse(dummyBusiness.isStringPalindromeAnagram("abcb"));
    }

}