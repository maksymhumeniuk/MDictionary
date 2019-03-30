package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.di;

import dagger.Subcomponent;
import ua.com.mdictionary.datalayer.di.scope.PerFragment;
import ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.LessonsFragment;

@PerFragment
@Subcomponent(modules = LessonsModule.class)
public interface LessonsSubcomponent {

    void inject(LessonsFragment lessonsFragment);

}
