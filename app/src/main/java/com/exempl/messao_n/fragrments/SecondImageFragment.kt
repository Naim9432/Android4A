package com.exempl.messao_n.fragrments

import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.bumptech.glide.request.target.BitmapImageViewTarget
import com.bumptech.glide.request.transition.Transition
import kotlinx.android.synthetic.main.fragment_first_image.*
import kotlinx.android.synthetic.main.fragment_second_image.*

class SecondImageFragment : Fragment() {

    private val imageUrl = "https://www.w3schools.com/w3css/img_lights.jpg"

    private fun loadIamgeUsingGlide() {
        secondFragmentprogressBar.visibility = View.VISIBLE
        GlideApp.with(context!!).asBitmap()
                .load(Uri.parse(imageUrl))
                .into(object : BitmapImageViewTarget(secondFragmentImageView){
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        super.onResourceReady(resource, transition)
                        secondFragmentprogressBar.visibility = View.INVISIBLE
                        secondFragmentImageView.isVisible = true
                    }
                })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadIamgeUsingGlide()
    }

    companion object {
        fun newInstance() = SecondImageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_second_image, container, false)
    }
}