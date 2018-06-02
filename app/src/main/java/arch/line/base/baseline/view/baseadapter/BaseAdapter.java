package arch.line.base.baseline.view.baseadapter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;
import java.util.Objects;

import arch.line.base.baseline.view.BaseActivity;
import arch.line.base.baseline.view.baseadapter.viewholder.BaseViewHolder;

public abstract class BaseAdapter<T, H extends BaseViewHolder<T>> extends RecyclerView.Adapter<H> {
    @Nullable
    private LiveData<List<T>> listItem;
    @Nullable
    private BaseActivity activity ;

    public BaseAdapter(@NonNull BaseActivity activity, @NonNull LiveData<List<T>> listItem) {
        this.activity = activity;
        this.listItem = listItem;
        listItem.observe(activity, new Observer<List<T>>() {
            @Override
            public void onChanged(@Nullable List<T> ts) {
                notifyDataSetChanged();
            }
        });
    }

    @NonNull
    @Override
    abstract public H onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull H holder, int position){
        assert listItem != null;
        @NonNull  T item = Objects.requireNonNull(listItem.getValue()).get(position);
        holder.bindView(item);
    }

    @Override
    public int getItemCount() {
        if (listItem != null) {
            return (listItem.getValue() != null) ? (listItem.getValue().size()) : (0);
        } else {
            return 0;
        }
    }

    /**
     * load list from viewModel only in observable
     *
     * @param listItem this list is not updatable
     */
    public void setList(LiveData<List<T>> listItem) {
        this.listItem = listItem;
        notifyDataSetChanged();
    }

    @Nullable
    public BaseActivity getContext() {
        return activity;
    }

}
