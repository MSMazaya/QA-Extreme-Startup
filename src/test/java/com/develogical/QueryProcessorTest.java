package com.develogical;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Test;

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
        assertThat(queryProcessor.process("What is 16 plus 79?"), containsString("95"));
    }

    @Test
    public void canDoMax() throws Exception {
        assertThat(queryProcessor.process("Which of the following numbers is the largest: 38, 2, 11?"), containsString("38"));
    }

    @Test
    public void canDoMult() throws Exception {
        assertThat(queryProcessor.process("What is 44 multiplied by 42?"), containsString("1848"));
    }

    @Test
    public void canDoPrime() throws Exception {
        assertThat("Which of the following numbers are primes: 99, 13, 3, 77, 71?", containsString("3"));
    }
}
