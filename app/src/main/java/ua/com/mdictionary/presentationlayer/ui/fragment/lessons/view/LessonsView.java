package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view;


import ua.com.mdictionary.core.view.BaseView;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.viewmodel.LessonsViewModel;

public interface LessonsView extends BaseView {

    void startAddressScreen(LessonsViewModel viewModel);

    /*void changeClickBehavior(boolean isMultiSelect);*/
}
