package ua.com.mdictionary.core.view.adapter;


import android.support.v7.widget.RecyclerView;

import ua.com.mdictionary.core.view.viewmodel.ViewModel;

/**
 * Item for {@link RecyclerView} {@link BindingAdapter}
 *
 * @param <VM> item viewModel type
 */
public abstract class BaseBindingItem<VM extends ViewModel> {

    private VM viewModel;
    /**
     * Item type. Should contain item layout id
     */
    private int itemType;

    /**
     * BR (binding resource) layout variable for item viewModel
     */
    private int itemBindingVariable;


    /**
     * @param itemType should contain item layout id
     */
    public BaseBindingItem(VM viewModel, int itemType, int itemBindingVariable) {
        this.viewModel = viewModel;
        this.itemType = itemType;
        this.itemBindingVariable = itemBindingVariable;
    }


    public VM getViewModel() {
        return viewModel;
    }

    public void setViewModel(VM viewModel) {
        this.viewModel = viewModel;
    }

    public int getItemType() {
        return itemType;
    }

    public int getItemBindingVariable() {
        return itemBindingVariable;
    }


}
