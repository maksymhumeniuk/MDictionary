package ua.com.mdictionary.presentationlayer.ui.fragment.lessons.view.adapter;


import ua.com.mdictionary.core.view.adapter.BindingAdapter;
import ua.com.mdictionary.core.view.adapter.BindingHolder;

public class LessonsAdapter extends BindingAdapter<LessonsItem> {

    //private OnItemLongClickListener<LessonsItem> onItemLongClickListener;

    @Override
    public void onBindViewHolder(BindingHolder viewHolder, int position) {
        super.onBindViewHolder(viewHolder, position);
        /*viewHolder.binding.getRoot().setOnLongClickListener(view -> {
            if (onItemLongClickListener != null) {
                onItemLongClickListener.onLongClick(getItems().get(position));
            }
            return true;
        });*/
    }

    /*public void setOnLongClickListener(OnItemLongClickListener<LessonsItem> longClickListener) {
        this.onItemLongClickListener = longClickListener;
    }

    public interface OnItemLongClickListener<I extends BaseBindingItem> {
        void onLongClick(I item);
    }*/
}
