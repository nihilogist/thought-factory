package org.nihilogist.thoughts;


import java.util.ArrayList;
import java.util.List;

public class ThoughtGenerator implements ThoughtFactory {

    private List<Thought> thoughts;

    public ThoughtGenerator() {
        thoughts = new ArrayList<Thought>();
        thoughts.add(new Thought("When you're curious, you find lots of interesting things to do.", "Walt Disney", null));
        thoughts.add(new Thought("How inappropriate to call this planet earth when it is quite clearly Ocean.", "Arthur C. Clarke", ""));
        thoughts.add(new Thought("There is nothing good or bad; only thinking makes it so", "William Shakespeare", "Hamlet"));
    }


    public Thought getThought() {
        int count = (int) (Math.random() * thoughts.size());

        return thoughts.get(count);
    }



}
