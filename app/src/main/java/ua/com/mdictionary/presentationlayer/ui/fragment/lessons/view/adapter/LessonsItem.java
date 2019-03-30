package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.adapter;

import ua.com.mdictionary.R;
import ua.com.mdictionary.core.view.adapter.BaseBindingItem;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.viewmodel.LessonsViewModel;

public class LessonsItem extends BaseBindingItem<LessonsViewModel> {

    public LessonsItem(LessonsViewModel viewModel, int itemBindingVariable) {
        super(viewModel, R.layout.item_lesson, itemBindingVariable);
    }
}
