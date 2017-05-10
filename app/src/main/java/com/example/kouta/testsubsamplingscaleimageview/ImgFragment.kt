package com.example.kouta.testsubsamplingscaleimageview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.davemorrissey.labs.subscaleview.ImageSource
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView

/**
 * Created by kouta on 2017/05/10.
 */
class ImgFragment : Fragment() {

    val IMG_FRAGMENT_KEY = "hoge"

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater?.inflate(R.layout.fragment,container,false)
        val img = v?.findViewById(R.id.img) as SubsamplingScaleImageView

        savedInstanceState?.let {
            img.setImage(ImageSource.resource(it.getInt(IMG_FRAGMENT_KEY)))
            return v
        }

        img.setImage(ImageSource.resource(R.drawable.img))
        return v
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        view.let {
            outState?.putInt(IMG_FRAGMENT_KEY,R.drawable.img)
        }
    }
}