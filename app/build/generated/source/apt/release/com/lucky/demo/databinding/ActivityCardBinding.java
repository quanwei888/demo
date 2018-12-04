package com.lucky.demo.databinding;
import com.lucky.demo.R;
import com.lucky.demo.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityCardBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.enExample, 3);
        sViewsWithIds.put(R.id.cnExample, 4);
        sViewsWithIds.put(R.id.mean, 5);
        sViewsWithIds.put(R.id.doneBtn, 6);
        sViewsWithIds.put(R.id.goonBtn, 7);
    }
    // views
    @NonNull
    public final android.widget.TextView cnExample;
    @NonNull
    public final android.widget.Button doneBtn;
    @NonNull
    public final android.widget.TextView enExample;
    @NonNull
    public final android.widget.Button goonBtn;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.widget.TextView mean;
    @NonNull
    public final android.widget.TextView pt;
    @NonNull
    public final android.widget.TextView word;
    // variables
    @Nullable
    private com.lucky.demo.data.Word mWord;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityCardBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds);
        this.cnExample = (android.widget.TextView) bindings[4];
        this.doneBtn = (android.widget.Button) bindings[6];
        this.enExample = (android.widget.TextView) bindings[3];
        this.goonBtn = (android.widget.Button) bindings[7];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mean = (android.widget.TextView) bindings[5];
        this.pt = (android.widget.TextView) bindings[2];
        this.pt.setTag(null);
        this.word = (android.widget.TextView) bindings[1];
        this.word.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.word == variableId) {
            setWord((com.lucky.demo.data.Word) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setWord(@Nullable com.lucky.demo.data.Word Word) {
        this.mWord = Word;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.word);
        super.requestRebind();
    }
    @Nullable
    public com.lucky.demo.data.Word getWord() {
        return mWord;
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
        java.lang.String wordWord = null;
        java.lang.String wordPt = null;
        com.lucky.demo.data.Word Word1 = mWord;

        if ((dirtyFlags & 0x3L) != 0) {



                if (Word1 != null) {
                    // read word.word
                    wordWord = Word1.word;
                    // read word.pt
                    wordPt = Word1.pt;
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.pt, wordPt);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.word, wordWord);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityCardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityCardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityCardBinding>inflate(inflater, com.lucky.demo.R.layout.activity_card, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityCardBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityCardBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.lucky.demo.R.layout.activity_card, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityCardBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityCardBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_card_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityCardBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): word
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}