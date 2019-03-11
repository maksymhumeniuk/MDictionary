package ua.com.mdictionary.presentationlayer.ui.fragment.objects.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import ua.com.mdictionary.BR;
import ua.com.mdictionary.core.view.viewmodel.ViewModel;


public class ObjectViewModel extends BaseObservable implements ViewModel {

    private String name;
    private String description;
    private String startTime;
    private String pastTime;
    private String lastTxTime;
    private String address;
    private boolean itemSelected;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Bindable
    public boolean isItemSelected() {
        return itemSelected;
    }

    public void setItemSelected(boolean itemSelected) {
        this.itemSelected = itemSelected;
        notifyPropertyChanged(BR.itemSelected);
    }

    @Bindable
    public String getTitle() {
        return name;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Bindable
    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Bindable
    public String getPastTime() {
        return pastTime;
    }

    public void setPastTime(String pastTime) {
        this.pastTime = pastTime;
    }

    @Bindable
    public String getLastTxTime() {
        return lastTxTime;
    }

    public void setLastTxTime(String lastTxTime) {
        this.lastTxTime = lastTxTime;
    }

    @Bindable
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
