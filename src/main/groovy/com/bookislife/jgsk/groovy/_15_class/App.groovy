package com.bookislife.jgsk.groovy._15_class

/**
 * Created by SidneyXu on 2015/09/22.
 */
class App {

    static void main(String[] args) {
        testPerson()
        testMan()
        testImmutableSong()
    }

    def static testPerson() {
        def person = new Person()
        person.age = 10
        assert person.age == 10

        person.setAge(12)
        assert person.age == 12

        person.privateAge = 20
        person.privateAge = 14
        assert person.age == 20
    }

    def static testMan() {
        def fred = new Man(name: "Fred", age: 21)
        def peter = new Man(name: "Peter")
        def jack = new Man(age: 21)
        def terry = new Man(from: "LA", description: "A man from LA.")

        println(fred)
        println(peter)
        println(jack)
        println(terry)
    }

    def static testImmutableSong() {
        ImmutableSong song = new ImmutableSong(name: "Canon in D major",
                artist: "Johann Pachelbel",
                publishDate: new Date())
        //  Wrong!! Cannot set readonly property
        //        song.artist = "foo"
        println(song.getPublishDate())
    }

}
