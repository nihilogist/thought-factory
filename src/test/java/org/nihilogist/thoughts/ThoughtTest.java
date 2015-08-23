package org.nihilogist.thoughts;


import org.junit.Test;
import static org.junit.Assert.*;

public class ThoughtTest {


    @Test
    public void twoEqualThoughtsShouldBeEqual() {
        Thought firstThought = new Thought("I think therefore I am", "Decartes", "Some book");
        Thought secondThought = new Thought("I think therefore I am", "Decartes", "Some book");
        assertEquals(firstThought, secondThought);
    }

    @Test
    public void thoughtsShouldConvertNicelyToJson() {
        Thought firstThought = new Thought("I think therefore I am", "Decartes", "Some book");
        String jsonString = firstThought.asJson();
        String expectedJson = "{\"quote\":\"I think therefore I am\",\"author\":\"Decartes\",\"source\":\"Some book\"}";
        assertEquals("Json conversion failed", expectedJson, jsonString);
    }
}
