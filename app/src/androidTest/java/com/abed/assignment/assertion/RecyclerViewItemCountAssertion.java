package com.abed.assignment.assertion;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewAssertion;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import org.hamcrest.Matchers;
import org.junit.Assert;

/**
 * Created by abed on 11/15/16.
 */

public class RecyclerViewItemCountAssertion implements ViewAssertion {
    private final int mExpectedCount;

    public RecyclerViewItemCountAssertion(int expectedCount) {
        this.mExpectedCount = expectedCount;
    }

    @Override
    public void check(View view, NoMatchingViewException noViewFoundException) {
        if (noViewFoundException != null) {
            throw noViewFoundException;
        }

        RecyclerView recyclerView = (RecyclerView) view;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        Assert.assertThat(adapter.getItemCount(), Matchers.is(mExpectedCount));
    }
}
