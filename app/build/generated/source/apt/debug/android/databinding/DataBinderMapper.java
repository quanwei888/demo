
package android.databinding;
import com.lucky.demo.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 26;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.lucky.demo.R.layout.item_book_list:
                    return com.lucky.demo.databinding.ItemBookListBinding.bind(view, bindingComponent);
                case com.lucky.demo.R.layout.activity_main:
                    return com.lucky.demo.databinding.ActivityMainBinding.bind(view, bindingComponent);
                case com.lucky.demo.R.layout.activity_card:
                    return com.lucky.demo.databinding.ActivityCardBinding.bind(view, bindingComponent);
                case com.lucky.demo.R.layout.activity_book_list:
                    return com.lucky.demo.databinding.ActivityBookListBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case 1251441662: {
                if(tag.equals("layout/item_book_list_0")) {
                    return com.lucky.demo.R.layout.item_book_list;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.lucky.demo.R.layout.activity_main;
                }
                break;
            }
            case 137720076: {
                if(tag.equals("layout/activity_card_0")) {
                    return com.lucky.demo.R.layout.activity_card;
                }
                break;
            }
            case 115224442: {
                if(tag.equals("layout/activity_book_list_0")) {
                    return com.lucky.demo.R.layout.activity_book_list;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"
            ,"book"
            ,"data"
            ,"statInfo"};
    }
}