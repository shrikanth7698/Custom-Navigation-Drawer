package com.shrikanthravi.customnavigationdrawer2.utils;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

import com.shrikanthravi.customnavigationdrawer2.widget.SNavigationDrawer;

public class CustomViewFactory implements LayoutInflater.Factory {
    private static CustomViewFactory mInstance;

    public static CustomViewFactory getInstance () {
        if (mInstance == null) {
            mInstance = new CustomViewFactory();
        }

        return mInstance;
    }

    private CustomViewFactory () {}

    @Override
    public View onCreateView (String name, Context context, AttributeSet attrs) {
        //Check if it's one of our custom classes, if so, return one using
        //the Context/AttributeSet constructor
        if (SNavigationDrawer.class.getSimpleName().equals(name)) {
            return new SNavigationDrawer(context, attrs);
        }

        //Not one of ours; let the system handle it
        return null;
    }
}
