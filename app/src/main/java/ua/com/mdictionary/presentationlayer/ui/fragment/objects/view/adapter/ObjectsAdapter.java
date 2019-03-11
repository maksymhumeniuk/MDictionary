package ua.com.mdictionary.presentationlayer.ui.fragment.objects.view.adapter;


import ua.com.mdictionary.core.view.adapter.BindingAdapter;
import ua.com.mdictionary.core.view.adapter.BindingHolder;

public class ObjectsAdapter extends BindingAdapter<ObjectItem> {

    //private OnItemLongClickListener<ObjectItem> onItemLongClickListener;

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

    /*public void setOnLongClickListener(OnItemLongClickListener<ObjectItem> longClickListener) {
        this.onItemLongClickListener = longClickListener;
    }

    public interface OnItemLongClickListener<I extends BaseBindingItem> {
        void onLongClick(I item);
    }*/
}
