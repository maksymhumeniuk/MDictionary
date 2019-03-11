package ua.com.mdictionary.presentationlayer.ui.fragment.objects.di;

import dagger.Subcomponent;
import ua.com.mdictionary.datalayer.di.scope.PerFragment;
import ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.ObjectsFragment;

@PerFragment
@Subcomponent(modules = ObjectsModule.class)
public interface ObjectsSubcomponent {

    void inject(ObjectsFragment objectsFragment);

}
