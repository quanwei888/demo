package com.lucky.demo.databinding;
import com.lucky.demo.R;
import com.lucky.demo.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityMainBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.TextView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    @NonNull
    private final android.widget.TextView mboundView5;
    // variables
    @Nullable
    private java.util.Map mData;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityMainBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.TextView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.TextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (android.widget.TextView) bindings[5];
        this.mboundView5.setTag(null);
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
        if (BR.data == variableId) {
            setData((java.util.Map) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setData(@Nullable java.util.Map Data) {
        this.mData = Data;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
    }
    @Nullable
    public java.util.Map getData() {
        return mData;
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
        int userDataUserStatDone = 0;
        java.lang.String stringValueOfUserDataUserStatDone = null;
        java.lang.String stringValueOfUserDataUserStatDoing = null;
        java.lang.String userDataUserName = null;
        java.lang.String stringValueOfUserDataUserBookWordCount = null;
        java.lang.Object dataUser = null;
        java.lang.String userDataUserBookName = null;
        java.util.Map data = mData;
        int userDataUserBookWordCount = 0;
        com.lucky.demo.data.room.RoomEntity.User userDataUser = null;
        int userDataUserStatDoing = 0;

        if ((dirtyFlags & 0x3L) != 0) {



                if (data != null) {
                    // read data.user
                    dataUser = data.get("user");
                }


                // read (User) data.user
                userDataUser = ((com.lucky.demo.data.room.RoomEntity.User) (dataUser));


                if (userDataUser != null) {
                    // read (User) data.user.statDone
                    userDataUserStatDone = userDataUser.statDone;
                    // read (User) data.user.name
                    userDataUserName = userDataUser.name;
                    // read (User) data.user.bookName
                    userDataUserBookName = userDataUser.bookName;
                    // read (User) data.user.bookWordCount
                    userDataUserBookWordCount = userDataUser.bookWordCount;
                    // read (User) data.user.statDoing
                    userDataUserStatDoing = userDataUser.statDoing;
                }


                // read String.valueOf((User) data.user.statDone)
                stringValueOfUserDataUserStatDone = java.lang.String.valueOf(userDataUserStatDone);
                // read String.valueOf((User) data.user.bookWordCount)
                stringValueOfUserDataUserBookWordCount = java.lang.String.valueOf(userDataUserBookWordCount);
                // read String.valueOf((User) data.user.statDoing)
                stringValueOfUserDataUserStatDoing = java.lang.String.valueOf(userDataUserStatDoing);
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView1, userDataUserName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, userDataUserBookName);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, stringValueOfUserDataUserBookWordCount);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, stringValueOfUserDataUserStatDone);
            android.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView5, stringValueOfUserDataUserStatDoing);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityMainBinding>inflate(inflater, com.lucky.demo.R.layout.activity_main, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.lucky.demo.R.layout.activity_main, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityMainBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_main_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityMainBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): data
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}