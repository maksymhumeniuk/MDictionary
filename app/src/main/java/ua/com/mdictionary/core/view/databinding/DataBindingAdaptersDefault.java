package ua.com.mdictionary.core.view.databinding;


import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.ImageView;

import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestCreator;
import com.squareup.picasso.Transformation;

import java.io.File;
import java.util.Collection;
import java.util.List;

import ua.com.mdictionary.core.view.adapter.BaseBindingItem;
import ua.com.mdictionary.core.view.adapter.BindingAdapter;
import ua.com.mdictionary.core.view.image.CircleTransformation;


public class DataBindingAdaptersDefault implements DataBindingAdapters {

    @Override
    public void loadImage(ImageView view, String src, Drawable placeholder, Drawable error, Boolean cache, String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown, boolean circle, Transformation transformation, List<Transformation> transformations) {
        if (src != null) {
            RequestCreator builder = Picasso.with(view.getContext()).load(src);
            loadImage(view, builder, placeholder, error, cache, scaleMode, resizeWidth, resizeHeight, onlyScaleDown, circle, transformation, transformations);
        } else if (placeholder != null) view.setImageDrawable(placeholder);
        else view.setImageResource(android.R.color.transparent);
    }

    @Override
    public void loadImage(ImageView view, Uri src, Drawable placeholder, Drawable error, Boolean cache, String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown, boolean circle, Transformation transformation, List<Transformation> transformations) {
        if (src != null) {
            RequestCreator builder = Picasso.with(view.getContext()).load(src);
            loadImage(view, builder, placeholder, error, cache, scaleMode, resizeWidth, resizeHeight, onlyScaleDown, circle, transformation, transformations);
        } else if (placeholder != null) view.setImageDrawable(placeholder);
        else view.setImageResource(android.R.color.transparent);
    }

    @Override
    public void loadImage(ImageView view, File src, Drawable placeholder, Drawable error, Boolean cache, String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown, boolean circle, Transformation transformation, List<Transformation> transformations) {

        RequestCreator builder = Picasso.with(view.getContext()).load(src);
        loadImage(view, builder, placeholder, error, cache, scaleMode, resizeWidth, resizeHeight, onlyScaleDown, circle, transformation, transformations);
    }

    @Override
    public void loadImage(ImageView view, Integer src, Drawable placeholder, Drawable error, Boolean cache, String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown, boolean circle, Transformation transformation, List<Transformation> transformations) {

        RequestCreator builder = Picasso.with(view.getContext()).load(src);
        loadImage(view, builder, placeholder, error, cache, scaleMode, resizeWidth, resizeHeight, onlyScaleDown, circle, transformation, transformations);
    }

    private void loadImage(ImageView view, RequestCreator builder, Drawable placeholder, Drawable error,
                           Boolean cache,
                           String scaleMode, Integer resizeWidth, Integer resizeHeight, boolean onlyScaleDown,
                           boolean circle, Transformation transformation, List<Transformation> transformations) {

        if (placeholder != null) builder.placeholder(placeholder);
        if (error != null) builder.error(error);

        if (circle) builder.transform(new CircleTransformation());
        if (transformation != null) builder.transform(transformation);
        if (transformations != null) builder.transform(transformations);

        if (onlyScaleDown) builder.onlyScaleDown();

        if (resizeWidth != null && resizeHeight != null) {
            builder.resize(resizeWidth, resizeHeight);
        }
        if (scaleMode != null) {
            if (resizeWidth == null || resizeHeight == null) {
                builder.fit();
            }
            switch (scaleMode) {
                case CENTER_CROP:
                    builder.centerCrop();
                    break;
                case CENTER_INSIDE:
                    builder.centerInside();
                    break;
                default:
                    throw new RuntimeException("Invalid scaleMode for image in dataBindingAdapter");
            }
        }
        if (cache != null) {
            if (!cache) {
                builder.memoryPolicy(MemoryPolicy.NO_CACHE);
                builder.networkPolicy(NetworkPolicy.NO_CACHE);
            }
        }
        builder.into(view);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <I extends BaseBindingItem> void setItems(RecyclerView recyclerView, Collection<I> items) {
        BindingAdapter<I> adapter = (BindingAdapter<I>) recyclerView.getAdapter();
        if (adapter != null) {
            adapter.setItems(items);
        }
    }

    @Override
    public void setSelection(EditText editText, int position) {
        editText.setSelection(position);
    }


}
