package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.List;

import ua.com.mdictionary.BR;
import ua.com.mdictionary.core.view.viewmodel.ViewModel;


public class LessonsViewModel extends BaseObservable implements ViewModel {

    private String title;
    private String description;
    private int drawableRes;
    private List<String> dictionaryWords;

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
        notifyPropertyChanged(BR.description);
    }

    @Bindable
    public int getDrawableRes() {
        return drawableRes;
    }

    public void setDrawableRes(int drawableRes) {
        this.drawableRes = drawableRes;
        notifyPropertyChanged(BR.drawableRes);
    }

    public List<String> getDictionaryWords() {
        return dictionaryWords;
    }

    public void setDictionaryWords(List<String> dictionaryWords) {
        this.dictionaryWords = dictionaryWords;
    }
}
