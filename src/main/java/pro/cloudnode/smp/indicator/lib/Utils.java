package pro.cloudnode.smp.indicator.lib;

import static java.lang.Math.pow;

public class Utils
{
	// Border at which #fff becomes #000
	public static final float LUMINOSITY_BORDER = 0.179f;

	/**
	 * Calculate the luminosity of a colour
	 * @param color the colour to calculate the luminosity of
	 * @return the luminosity (0 - 1)
	 * @link <a href="https://en.wikipedia.org/wiki/Relative_luminance">the weights of colours used in RGB luminosity</a>
	 */
	public static float luminosity(int color)
	{
		float r = ((color >> 16) & 0xFF) / 255f;
		float g = ((color >> 8) & 0xFF) / 255f;
		float b = (color & 0xFF) / 255f;

		r = (float) ((r <= 0.04045) ? pow(r / 12.92, 2.4) : pow((r + 0.055) / 1.055, 2.4));
		g = (float) ((g <= 0.04045) ? pow(g / 12.92, 2.4) : pow((g + 0.055) / 1.055, 2.4));
		b = (float) ((b <= 0.04045) ? pow(b / 12.92, 2.4) : pow((b + 0.055) / 1.055, 2.4));

		return 0.2126f * r + 0.7152f * g + 0.0722f * b;
	}

	/**
	 * Get a text color contrast based on its background color
	 * @param color the background color of the text
	 * @return the text color
	 * @implNote {@link Utils#luminosity(int)}
	 */
	public static int contrast(int color)
	{
		if (luminosity(color) >= LUMINOSITY_BORDER) return 0x000000;
		return 0xFFFFFF;
	}
}
