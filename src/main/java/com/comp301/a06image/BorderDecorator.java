package com.comp301.a06image;

import java.awt.*;

public class BorderDecorator implements Image {

  private Image img;
  private int thiccness;
  private Color borderColor;

  public BorderDecorator(Image image, int thiccness, Color borderColor) {
    if (image == null || thiccness < 0) {
      throw new IllegalArgumentException();
    }
    this.img = image;
    this.thiccness = thiccness;
    this.borderColor = borderColor;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0
        || x >= (img.getWidth() + (2 * thiccness))
        || y < 0
        || y >= (img.getHeight() + (2 * thiccness))) throw new IllegalArgumentException();
    if (x < thiccness
        || x >= (img.getWidth() + thiccness)
        || y < thiccness
        || y >= (img.getHeight() + thiccness)) return this.borderColor;
    return img.getPixelColor(x - thiccness, y - thiccness);
  }

  @Override
  public int getWidth() {
    return (2 * thiccness) + img.getWidth();
  }

  @Override
  public int getHeight() {
    return (2 * thiccness) + img.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1 + img.getNumLayers();
  }
}
