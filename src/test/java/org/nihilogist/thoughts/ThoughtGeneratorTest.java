package org.nihilogist.thoughts;


import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ThoughtGeneratorTest {

    @Test
    public void shouldRetrieveThoughts() {
        ThoughtFactory thoughtFactory = new ThoughtGenerator();

        Thought thought = thoughtFactory.getThought();

        assertNotNull("Thought generator should not return null", thought);
    }

}
