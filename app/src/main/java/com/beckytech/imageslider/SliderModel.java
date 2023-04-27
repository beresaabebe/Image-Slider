package com.beckytech.imageslider;

import java.io.Serializable;

public class SliderModel implements Serializable {
    private final int image;
    private final String textTitle;
    private final String url;

    public SliderModel(int image, String textTitle, String url) {
        this.image = image;
        this.textTitle = textTitle;
        this.url = url;
    }

    public int getImage() {
        return image;
    }

    public String getTextTitle() {
        return textTitle;
    }

    public String getUrl() {
        return url;
    }
}
