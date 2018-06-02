package arch.line.base.baseline.view.baseadapter;

import android.arch.lifecycle.LiveData;
import android.arch.paging.PagedListAdapter;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

import arch.line.base.baseline.view.baseadapter.viewholder.BaseViewHolder;


/**
 * Must be used with view model
 * ref https://developer.android.com/topic/libraries/architecture/paging/
 */
public abstract class BasePageListAdapter<T extends LiveData, H extends BaseViewHolder<T>> extends PagedListAdapter<T, H> {


    public BasePageListAdapter(@NonNull DiffUtil.ItemCallback<T> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    abstract public H onCreateViewHolder(@NonNull ViewGroup parent, int viewType);

    @Override
    public void onBindViewHolder(@NonNull H holder, int position) {
        T item = getItem(position);
        holder.bindView(item);
    }


    /*
    /**
     * This below function should write for paging
     * Ref https://developer.android.com/reference/android/arch/paging/PagedListAdapter
     *

    public static final DiffUtil.ItemCallback<User> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<User>() {
                @Override
                public boolean areItemsTheSame(
                        @NonNull User oldUser, @NonNull User newUser) {
                    // User properties may have changed if reloaded from the DB, but ID is fixed
                    return oldUser.getId() == newUser.getId();
                }

                @Override
                public boolean areContentsTheSame(
                        @NonNull User oldUser, @NonNull User newUser) {
                    // NOTE: if you use equals, your object must properly override Object#equals()
                    // Incorrectly returning false here will result in too many animations.
                    return oldUser.equals(newUser);
                }
            };

            */

}
