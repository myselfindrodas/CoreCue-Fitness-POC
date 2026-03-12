package com.corecue.fitness.ui.camera

import android.graphics.Bitmap
import android.graphics.ImageFormat
import android.graphics.Rect
import android.graphics.YuvImage
import androidx.camera.core.ImageProxy
import java.io.ByteArrayOutputStream
import java.nio.ByteBuffer

fun ImageProxy.toBitmap(): Bitmap {
    if (format != ImageFormat.YUV_420_888) {
        throw IllegalArgumentException("Unsupported image format: $format")
    }
    val nv21 = yuv420888ToNv21(this)
    val yuvImage = YuvImage(nv21, ImageFormat.NV21, width, height, null)
    val out = ByteArrayOutputStream()
    yuvImage.compressToJpeg(Rect(0, 0, width, height), 90, out)
    val bytes = out.toByteArray()
    return android.graphics.BitmapFactory.decodeByteArray(bytes, 0, bytes.size)
}

private fun yuv420888ToNv21(image: ImageProxy): ByteArray {
    val yBuffer: ByteBuffer = image.planes[0].buffer
    val uBuffer: ByteBuffer = image.planes[1].buffer
    val vBuffer: ByteBuffer = image.planes[2].buffer

    val ySize = yBuffer.remaining()
    val uSize = uBuffer.remaining()
    val vSize = vBuffer.remaining()

    val nv21 = ByteArray(ySize + uSize + vSize)
    yBuffer.get(nv21, 0, ySize)
    vBuffer.get(nv21, ySize, vSize)
    uBuffer.get(nv21, ySize + vSize, uSize)
    return nv21
}
