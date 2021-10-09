package divyansh.tech.wallup.common

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

@BindingAdapter("image")
fun bindImage(imageView: AppCompatImageView, image: String) {
    Glide.with(imageView.context)
        .load(image)
        .skipMemoryCache(true)
        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
        .into(imageView)
}