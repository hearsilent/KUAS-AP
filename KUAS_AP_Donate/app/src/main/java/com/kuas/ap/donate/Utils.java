package com.kuas.ap.donate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;
import com.nostra13.universalimageloader.core.process.BitmapProcessor;

@SuppressWarnings("unused")
public class Utils {

	public static ImageLoader getDefaultImageLoader(Context context) {
		ImageLoaderConfiguration config =
				new ImageLoaderConfiguration.Builder(context).threadPoolSize(5).build();
		ImageLoader imageLoader = ImageLoader.getInstance();
		imageLoader.init(config);

		return imageLoader;
	}

	public static DisplayImageOptions getHeadDisplayImageOptions(int cornerPixels) {
		// rounded head
		return new DisplayImageOptions.Builder().cacheInMemory(true).cacheOnDisk(true)
				.bitmapConfig(Bitmap.Config.ARGB_4444).imageScaleType(ImageScaleType.IN_SAMPLE_POWER_OF_2)
				.showImageOnLoading(R.drawable.ic_head_anon).preProcessor(new BitmapProcessor() {

					public Bitmap process(Bitmap src) {
						int yOffset = (src.getHeight() - src.getWidth());
                        Matrix matrix = new Matrix();
                        matrix.postScale(((float) src.getHeight()) / src.getWidth(), 1);
                        //Bitmap result = Bitmap.createScaledBitmap(src, src.getHeight(), src.getHeight(), true);
                        Bitmap result = Bitmap.createBitmap(src, 0, yOffset/2, src.getWidth(), src.getWidth());
						//Bitmap result = Bitmap.createBitmap(src, 0, 0, src.getWidth(),
						//		src.getHeight(), matrix, false);
						src.recycle();

						return result;
					}
				}).displayer(new RoundedBitmapDisplayer(cornerPixels)).build();
	}
}
