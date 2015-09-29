package com.bookislife.jgsk.groovy._19_inherit

/**
 * Created by SidneyXu on 2015/09/29.
 */
class App {

    public static void main(String[] args) {
        def openButton = new Button(text: "Open", width: 100, height: 100)
        openButton.onClick()

        def textview = [getDescription: { -> }] as View
        textview.metaClass.getDescription = { -> "This is a TextView." }
        println(textview.getDescription())

        def listener = [onClick: { -> println("Trigger click event.") }] as OnClickListener
        listener.onClick()
    }

}