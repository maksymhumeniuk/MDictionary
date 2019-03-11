package ua.com.mdictionary.core.view.viewmodel;

import static ua.com.mdictionary.core.view.databinding.DataBindingAdapters.CENTER_CROP;
import static ua.com.mdictionary.core.view.databinding.DataBindingAdapters.CENTER_INSIDE;

/**
 * ViewModel base interface
 */
public interface ViewModel {

    /**
     * CenterInside scale mode for dataBinding
     */
    String centerInside = CENTER_INSIDE;

    /**
     * CenterCrop scale mode for dataBinding
     */
    String centerCrop = CENTER_CROP;
}
