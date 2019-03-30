package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.mapper;

import java.util.ArrayList;
import java.util.List;

import ua.com.mdictionary.BR;
import ua.com.mdictionary.datalayer.network.response.LessonsResponse;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.adapter.LessonsItem;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.viewmodel.LessonsViewModel;

public class LessonsMapper {

    public List<LessonsItem> mapLessons(List<LessonsResponse> objectsResponse) {
        List<LessonsItem> result = new ArrayList<>();
        for (LessonsResponse lesson : objectsResponse) {
            LessonsViewModel viewModel = new LessonsViewModel();
            viewModel.setTitle(lesson.getTitle());
            viewModel.setDescription(lesson.getDescription());
            viewModel.setDictionaryWords(lesson.getDictionaryWords());
            viewModel.setDrawableRes(lesson.getDrowableRess());
            LessonsItem item = new LessonsItem(viewModel, BR.viewModel);
            result.add(item);
        }
        return result;
    }

}
