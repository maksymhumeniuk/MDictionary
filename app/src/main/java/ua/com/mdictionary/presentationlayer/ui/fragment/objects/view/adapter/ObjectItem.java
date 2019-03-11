package ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.adapter;

import ua.com.mdictionary.R;
import ua.com.mdictionary.core.view.adapter.BaseBindingItem;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.viewmodel.ObjectViewModel;

public class ObjectItem extends BaseBindingItem<ObjectViewModel> {

    public ObjectItem(ObjectViewModel viewModel, int itemBindingVariable) {
        super(viewModel, R.layout.item_object, itemBindingVariable);
    }
}
