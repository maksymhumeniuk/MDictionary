package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import ua.com.mdictionary.R;
import ua.com.mdictionary.core.presenter.BasePresenter;
import ua.com.mdictionary.datalayer.network.response.LessonsResponse;
import ua.com.mdictionary.datalayer.preferences.PreferencesManager;
import ua.com.mdictionary.domainlayer.interactor.objects.ObjectsInteractor;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.mapper.LessonsMapper;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.LessonsView;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.viewmodel.LessonsScreenViewModel;

public class LessonsPresenter extends BasePresenter<LessonsView, LessonsScreenViewModel> {

    private ObjectsInteractor objectsInteractor;
    private LessonsMapper mapper;
    private PreferencesManager preferencesManager;


    public LessonsPresenter(ObjectsInteractor objectsInteractor,
                            LessonsMapper lessonsMapper,
                            PreferencesManager preferencesManager) {
        mapper = lessonsMapper;
        this.objectsInteractor = objectsInteractor;
        this.preferencesManager = preferencesManager;
        setViewModel(new LessonsScreenViewModel());
    }

    @Override
    public void onViewAttached(@Nullable Bundle savedInstanceState) {
        super.onViewAttached(savedInstanceState);
        getLessons();
    }

    private void getLessons() {
        viewModel.lessonsItems.addAll(mapper.mapLessons(getLessonsInfo()));
    }

    private List<LessonsResponse> getLessonsInfo() {
        List<LessonsResponse> listLessons = new ArrayList<>();
        LessonsResponse lessonOne = new LessonsResponse.Builder()
                .title("Lesson #1")
                .description("Animals")
                .drowableRess(R.drawable.ic_panda)
                .dictionaryWords(Arrays.asList("dog", "cat", "tiger"))
                .build();
        LessonsResponse lessonTwo = new LessonsResponse.Builder()
                .title("Lesson #2")
                .description("Food")
                .drowableRess(R.drawable.ic_panda)
                .dictionaryWords(Arrays.asList("an apple", "cheeseburger", "hot dog"))
                .build();
        listLessons.add(lessonOne);
        listLessons.add(lessonTwo);
        return listLessons;
    }
}

