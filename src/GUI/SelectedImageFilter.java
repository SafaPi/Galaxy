/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import java.awt.image.ImageFilter;
import java.awt.image.RGBImageFilter;

/**
 *
 * @author SafaPC
 */

    public class SelectedImageFilter extends RGBImageFilter {
    private final float rf, gf, bf;
    public SelectedImageFilter(float rf, float gf, float bf) {
        super();
        this.rf = Math.min(1f, rf);
        this.gf = Math.min(1f, gf);
        this.bf = Math.min(1f, bf);
        canFilterIndexColorModel = false;
    }
//     @Override public int filterRGB(int x, int y, int argb) {
//         Color color = new Color(argb, true);
//         float[] array = new float[4];
//         color.getComponents(array);
//         return new Color(array[0]*filter[0], array[1]*filter[1], array[2]*filter[2], array[3]).getRGB();
//     }
     public int filterRGB(int x, int y, int argb) {
        int r = (int) (((argb >> 16) & 0xff) * rf);
        int g = (int) (((argb >>  8) & 0xff) * gf);
        int b = (int) (((argb)       & 0xff) * bf);
        return (argb & 0xff000000) | (r << 16) | (g << 8) | (b);
    }
}
