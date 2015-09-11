package com.kenodoggy.databindingsample.observable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;


public class BindableObject extends BaseObservable{

    private String textValue;
    private String editTextValue;

    @Bindable
    public String getTextValue() {
        return textValue != null ? textValue : "";
    }

    public void setTextValue(String value) {
        if (verifyNewStringIsValid(textValue, value)) {
            this.textValue = value;
            notifyChange();
        }
    }

    @Bindable
    public String getEditTextValue() {
        return editTextValue != null ? editTextValue : "";
    }

    public void setEditTextValue(String value) {
        if (verifyNewStringIsValid(editTextValue, value)) {
            this.editTextValue = value;
            notifyChange();
            setTextValue(getEditTextValue());
        }
    }

    private boolean verifyNewStringIsValid(String oldValue, String newValue) {
        boolean isDifferent = false;
        if (oldValue == null && newValue != null) {
            isDifferent = true;
        }

        else if (oldValue != null && newValue != null && !oldValue.equals(newValue)) {
            isDifferent = true;
        }
        return isDifferent;
    }

    public TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            setEditTextValue(s.toString());
        }

        @Override
        public void afterTextChanged(Editable s) {
            Selection.setSelection(s, s.length());
        }
    };


}
