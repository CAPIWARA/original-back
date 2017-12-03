package br.com.original.entity;

/**
 * Created by @cardosomarcos on 03/12/17
 */
public class Chat {
    private Object intents;
    private Object input;
    private Object output;

    public Object getIntents() {
        return intents;
    }

    public void setIntents(Object intents) {
        this.intents = intents;
    }

    public Object getInput() {
        return input;
    }

    public void setInput(Object input) {
        this.input = input;
    }

    public Object getOutput() {
        return output;
    }

    public void setOutput(Object output) {
        this.output = output;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "intents=" + intents +
                ", input=" + input +
                ", output=" + output +
                '}';
    }
}
