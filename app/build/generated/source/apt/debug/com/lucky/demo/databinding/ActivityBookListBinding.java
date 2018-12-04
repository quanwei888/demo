package com.lucky.demo.databinding;
import com.lucky.demo.R;
import com.lucky.demo.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityBookListBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.list, 1);
    }
    // views
    @NonNull
    public final com.github.ksoichiro.android.observablescrollview.ObservableListView list;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    // variables
    @Nullable
    private java.util.Map mStatInfo;
    @Nullable
    private com.lucky.demo.data.room.RoomEntity.Book mBook;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityBookListBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 2, sIncludes, sViewsWithIds);
        this.list = (com.github.ksoichiro.android.observablescrollview.ObservableListView) bindings[1];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.statInfo == variableId) {
            setStatInfo((java.util.Map) variable);
        }
        else if (BR.book == variableId) {
            setBook((com.lucky.demo.data.room.RoomEntity.Book) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setStatInfo(@Nullable java.util.Map StatInfo) {
        this.mStatInfo = StatInfo;
    }
    @Nullable
    public java.util.Map getStatInfo() {
        return mStatInfo;
    }
    public void setBook(@Nullable com.lucky.demo.data.room.RoomEntity.Book Book) {
        this.mBook = Book;
    }
    @Nullable
    public com.lucky.demo.data.room.RoomEntity.Book getBook() {
        return mBook;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityBookListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityBookListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityBookListBinding>inflate(inflater, com.lucky.demo.R.layout.activity_book_list, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityBookListBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityBookListBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.lucky.demo.R.layout.activity_book_list, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityBookListBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityBookListBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_book_list_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityBookListBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): statInfo
        flag 1 (0x2L): book
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}