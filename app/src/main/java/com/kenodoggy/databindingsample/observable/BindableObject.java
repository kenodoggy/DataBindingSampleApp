package com.kenodoggy.databindingsample.observable;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;

import com.kenodoggy.databindingsample.BR;


public class BindableObject extends BaseObservable {

    private String textValue;
    private String editTextValue;

    @Bindable
    public String getTextValue() {
        return textValue != null ? textValue : "";
    }

    public void setTextValue(@NonNull final String value) {
        if (verifyNewStringIsValid(textValue, value)) {
            this.textValue = value;
            notifyPropertyChanged(BR.textValue);
        }
    }

    @Bindable
    public String getEditTextValue() {
        return editTextValue != null ? editTextValue : "";
    }

    public void setEditTextValue(@NonNull final String value) {
        if (verifyNewStringIsValid(editTextValue, value)) {
            this.editTextValue = value;
            notifyPropertyChanged(BR.editTextValue);
            setTextValue(getEditTextValue());
        }
    }

    private boolean verifyNewStringIsValid(@Nullable final String oldValue, @Nullable final String newValue) {
        boolean isDifferent = false;
        if (newValue != null) {
            if (oldValue == null || !oldValue.equals(newValue)) {
                isDifferent = true;
            }
        }

        return isDifferent;
    }

    final public TextWatcher watcher = new TextWatcher() {
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
