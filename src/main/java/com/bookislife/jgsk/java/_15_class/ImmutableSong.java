package com.bookislife.jgsk.java._15_class;

import java.util.Date;

/**
 * Created by SidneyXu on 2015/09/22.
 */
public class ImmutableSong {
    private final String name;
    private final String artist;
    private final Date publishDate;

    public ImmutableSong(final String name,
                         final String artist,
                         final Date publishDate) {
        this.artist = artist;
        this.name = name;
        this.publishDate = publishDate;
    }

    public String getArtist() {
        return artist;
    }

    public String getName() {
        return name;
    }

    public Date getPublishDate() {
        return new Date(publishDate.getTime());
    }
}
