package com.android.settings.custom.preference.indicator;

import androidx.annotation.Nullable;
import com.android.settings.custom.preference.indicator.animation.AnimationManager;
import com.android.settings.custom.preference.indicator.animation.controller.ValueController;
import com.android.settings.custom.preference.indicator.animation.data.Value;
import com.android.settings.custom.preference.indicator.draw.DrawManager;
import com.android.settings.custom.preference.indicator.draw.data.Indicator;

public class IndicatorManager implements ValueController.UpdateListener {

    private DrawManager drawManager;
    private AnimationManager animationManager;
    private Listener listener;

    interface Listener {
        void onIndicatorUpdated();
    }

    IndicatorManager(@Nullable Listener listener) {
        this.listener = listener;
        this.drawManager = new DrawManager();
        this.animationManager = new AnimationManager(drawManager.indicator(), this);
    }

    public AnimationManager animate() {
        return animationManager;
    }

    public Indicator indicator() {
        return drawManager.indicator();
    }

    public DrawManager drawer() {
        return drawManager;
    }

    @Override
    public void onValueUpdated(@Nullable Value value) {
        drawManager.updateValue(value);
        if (listener != null) {
            listener.onIndicatorUpdated();
        }
    }
}
