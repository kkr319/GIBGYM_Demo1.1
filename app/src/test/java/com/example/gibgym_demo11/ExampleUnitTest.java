package com.example.gibgym_demo11;

import com.example.gibgym_demo11.Authentication.RegisterFragment;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    RegisterFragment registerFragment = new RegisterFragment();
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void isValidPass(){
        boolean ivResult = registerFragment.isValidPassword("1235");
        assertEquals(false,ivResult);
    }

}