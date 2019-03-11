package ua.com.mdictionary.core.view.databinding;


import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.Transformation;

import java.io.File;
import java.util.Collection;
import java.util.List;

import ua.com.mdictionary.core.view.adapter.BaseBindingItem;


/**
 * DataBinding instance adapters for layouts
 */
public interface DataBindingAdapters {

    String CENTER_INSIDE = "centerInside";
    String CENTER_CROP = "centerCrop";


    /**
     * Sets image from url into the {@link ImageView}
     *
     * @param src           image url
     * @param scaleMode     determines scaleMode {@link DataBindingAdapters#CENTER_INSIDE}, {@link DataBindingAdapters#CENTER_CROP}
     * @param onlyScaleDown the image will only be resized if it's bigger than <code>resizeWidth</code> x <code>resizeHeight</code> pixels
     */
    @BindingAdapter(value = {"imageUrl", "placeholder", "error", "cache",
            "scaleMode", "resizeWidth", "resizeHeight", "onlyScaleDown",
            "circle", "transformation", "transformations"}, requireAll = false)
    void loadImage(ImageView view,
                   String src, Drawable placeholder, Drawable error,
                   Boolean cache,
                   String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                   boolean circle, Transformation transformation, List<Transformation> transformations);


    /**
     * Sets image from {@link Uri} into the {@link ImageView}
     *
     * @param src           image uri
     * @param scaleMode     determines scaleMode {@link DataBindingAdapters#CENTER_INSIDE}, {@link DataBindingAdapters#CENTER_CROP}
     * @param onlyScaleDown the image will only be resized if it's bigger than <code>resizeWidth</code> x <code>resizeHeight</code> pixels
     */
    @BindingAdapter(value = {"imageUri", "placeholder", "error", "cache",
            "scaleMode", "resizeWidth", "resizeHeight", "onlyScaleDown",
            "circle", "transformation", "transformations"}, requireAll = false)
    void loadImage(ImageView view,
                   Uri src, Drawable placeholder, Drawable error,
                   Boolean cache,
                   String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                   boolean circle, Transformation transformation, List<Transformation> transformations);


    /**
     * Sets image from {@link File} into the {@link ImageView}
     *
     * @param src           image file
     * @param scaleMode     determines scaleMode {@link DataBindingAdapters#CENTER_INSIDE}, {@link DataBindingAdapters#CENTER_CROP}
     * @param onlyScaleDown the image will only be resized if it's bigger than <code>resizeWidth</code> x <code>resizeHeight</code> pixels
     */
    @BindingAdapter(value = {"imageFile", "placeholder", "error", "cache",
            "scaleMode", "resizeWidth", "resizeHeight", "onlyScaleDown",
            "circle", "transformation", "transformations"}, requireAll = false)
    void loadImage(ImageView view,
                   File src, Drawable placeholder, Drawable error,
                   Boolean cache,
                   String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                   boolean circle, Transformation transformation, List<Transformation> transformations);


    /**
     * Sets image from drawable resources into the {@link ImageView}
     *
     * @param src           image drawable resource
     * @param scaleMode     determines scaleMode {@link DataBindingAdapters#CENTER_INSIDE}, {@link DataBindingAdapters#CENTER_CROP}
     * @param onlyScaleDown the image will only be resized if it's bigger than <code>resizeWidth</code> x <code>resizeHeight</code> pixels
     */
    @BindingAdapter(value = {"imageRes", "placeholder", "error", "cache",
            "scaleMode", "resizeWidth", "resizeHeight", "onlyScaleDown",
            "circle", "transformation", "transformations"}, requireAll = false)
    void loadImage(ImageView view,
                   Integer src, Drawable placeholder, Drawable error,
                   Boolean cache,
                   String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                   boolean circle, Transformation transformation, List<Transformation> transformations);


    /**
     * Sets items to {@link RecyclerView} {@link BindingAdapter}
     *
     * @param items list of items to display
     * @param <I>   item type
     */
    @BindingAdapter("items")
    <I extends BaseBindingItem> void setItems(RecyclerView recyclerView, Collection<I> items);

    /**
     * Sets selection to the editText
     *
     * @param editText
     * @param position selection position
     */
    @BindingAdapter("selection")
    void setSelection(EditText editText, int position);

}
