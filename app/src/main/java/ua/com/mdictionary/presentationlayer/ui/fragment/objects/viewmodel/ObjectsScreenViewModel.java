package ua.com.mdictionary.presentationlayer.ui.fragment.objects.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableList;

import ua.com.mdictionary.core.view.viewmodel.ViewModel;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.adapter.ObjectItem;

public class ObjectsScreenViewModel extends BaseObservable implements ViewModel {

    public ObservableList<ObjectItem> objects;

    public ObjectsScreenViewModel() {
        objects = new ObservableArrayList<>();
    }
}
