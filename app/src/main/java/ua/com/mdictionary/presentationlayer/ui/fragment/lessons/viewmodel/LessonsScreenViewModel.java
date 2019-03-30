package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import ua.com.mdictionary.core.view.viewmodel.ViewModel;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.adapter.LessonsItem;

public class LessonsScreenViewModel extends BaseObservable implements ViewModel {

    public ObservableList<LessonsItem> lessonsItems;

    public LessonsScreenViewModel() {
        lessonsItems = new ObservableArrayList<>();
    }
}
