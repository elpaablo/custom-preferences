package com.spark.support.preferences.indicator.animation.data.type;

import com.spark.support.preferences.indicator.animation.data.Value;

public class ThinWormAnimationValue extends WormAnimationValue implements Value {

    private int height;

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
