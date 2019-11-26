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

class FirstImageFragment : Fragment() {

    private val imageUrl = "https://www.numerama.com/content/uploads/2019/05/trou-noir-espace-univers-astronomie.jpg"

    private fun loadIamgeUsingGlide() {
        firstFragmentprogressBar.visibility = View.VISIBLE
        GlideApp.with(context!!).asBitmap()
                .load(Uri.parse(imageUrl))
                .into(object : BitmapImageViewTarget(firstFragmentImageView){
                    override fun onResourceReady(
                        resource: Bitmap,
                        transition: Transition<in Bitmap>?
                    ) {
                        super.onResourceReady(resource, transition)
                        firstFragmentprogressBar.visibility = View.INVISIBLE
                        firstFragmentImageView.isVisible = true
                    }
                })
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        loadIamgeUsingGlide()
    }

    companion object {
        fun newInstance() = FirstImageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_first_image, container, false)
    }
}