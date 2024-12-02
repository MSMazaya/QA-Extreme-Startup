package com.develogical;

import org.junit.Test;
import org.junit.Ignore;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("STM33"));
    }

    @Test
    public void canDoPlus() throws Exception {
        assertThat("What is 16 plus 79?", containsString("95"));
    }

    @Test
    public void canDoMax() throws Exception {
        assertThat("Which of the following numbers is the largest: 38, 2, 11?", containsString("38"));
    }
}
