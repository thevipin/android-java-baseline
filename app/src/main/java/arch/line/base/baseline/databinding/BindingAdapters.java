package arch.line.base.baseline.databinding;

import android.widget.ImageView;
import android.databinding.BindingAdapter;
import android.widget.TextView;


/**
 * Simple method to apply code to xml itself\
 * It can also used for object assign by xml itself
 * Ref https://developer.android.com/topic/libraries/data-binding/binding-adapters
 */
public class BindingAdapters {

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView,String url) {
        /*if (!url.isEmpty()) {
            Picasso.with(imageView.context)
                    .load(url)
                    .tag(url)
                    *//*.error(R.drawable.image_empty)*//*
                    *//*.placeholder(R.color.pixerfGray)*//*
                    .into(imageView);
        } else {
            *//*imageView.setImageResource(R.drawable.image_empty)*//*
        }*/
    }
    @BindingAdapter("reverseText")
    public static void showTextInReverse(TextView textView,String text){
        StringBuilder stringBuilder = new StringBuilder(text);
        textView.setText(stringBuilder.reverse().toString());
    }
}
