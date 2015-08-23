package org.nihilogist.thoughts;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Thought {

    public String asJson() {
        Gson gson = new GsonBuilder().create();
        return gson.toJson(this);
    }

    private String quote;
    private String author;
    private String source;

    public Thought(String quote, String author, String source) {
        this.quote = quote;
        this.author = author;
        this.source = source;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Thought thought = (Thought) o;

        if (quote != null ? !quote.equals(thought.quote) : thought.quote != null) return false;
        if (author != null ? !author.equals(thought.author) : thought.author != null) return false;
        return !(source != null ? !source.equals(thought.source) : thought.source != null);

    }

    @Override
    public int hashCode() {
        int result = quote != null ? quote.hashCode() : 0;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Thought{" +
                "quote='" + quote + '\'' +
                ", author='" + author + '\'' +
                ", source='" + source + '\'' +
                '}';
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
