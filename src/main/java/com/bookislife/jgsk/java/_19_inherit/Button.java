package com.bookislife.jgsk.java._19_inherit;

/**
 * Created by SidneyXu on 2015/09/29.
 */
public class Button extends View implements OnClickListener {

    private String text;

    public Button(String text, int width, int height) {
        this.text = text;
        this.width = width;
        this.height = height;
    }

    @Override
    public void onClick() {
        System.out.println("Click Button " + text);
    }

    @Override
    public String getDescription() {
        return text;
    }
}
