package com.codewithmosh.mediator;

import com.codewithmoshDemos.mediator.UIControl;

public class CheckBox extends UIControl {
    private boolean isChecked;

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
