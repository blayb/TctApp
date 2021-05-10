package com.blay.tctapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.blay.tctapp.R
import com.blay.tctapp.bean.ArticleDetails
import com.blay.tctapp.databinding.RowArticleLayoutBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.text.SimpleDateFormat
import java.util.*

class ArticlesAdapter(
    private var data: ArrayList<ArticleDetails>
) :
    RecyclerView.Adapter<ArticlesAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding: RowArticleLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(
            article: ArticleDetails
        ) {
            binding.title.text = article.title
            binding.type.text = article.category
            binding.authorName.text = article.author?.authorName

            // load image with glide for avatar icon
            Glide.with(binding.authorImage)
                .load(article.author?.authorAvatar?.imageUrl)
                .apply(RequestOptions.placeholderOf(android.R.color.darker_gray))
                .apply(RequestOptions.circleCropTransform())
                .into(binding.authorImage)

            // load image with glide for background Image
            Glide.with(binding.backgroundImage)
                .load(article.imageUrl)
                .apply(RequestOptions.placeholderOf(android.R.color.darker_gray))
                .into(binding.backgroundImage)

            // set images by data
            if (article.isLiked == true) {
                binding.likeIcon.setImageResource(R.drawable.like)
            } else {
                binding.likeIcon.setImageResource(R.drawable.un_like)
            }
            //set likes count
            binding.likeCount.text = article.likesCount.toString()

            if (article.isSaved == true) {
                binding.saveIcon.setImageResource(R.drawable.save)
            } else {
                binding.saveIcon.setImageResource(R.drawable.un_save)
            }

            val createDate = article.metaData?.creationTime
            if (createDate != null) {
                val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
                binding.articleDate.text = dateFormat.format(createDate)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            RowArticleLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val location = data[position]
        holder.bind(location)
    }
}