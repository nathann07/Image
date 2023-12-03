package com.comp301.a06image;

import java.awt.*;

public class ZoomDecorator implements Image {

  private Image img;
  private int multiplier;

  public ZoomDecorator(Image image, int multiplier) {
    if (image == null || multiplier < 1) {
      throw new IllegalArgumentException();
    }
    this.img = image;
    this.multiplier = multiplier;
  }

  public ZoomDecorator(Image image) {
    this(image, 2);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < 0 || x >= this.getWidth() || y < 0 || y >= this.getHeight())
      throw new IllegalArgumentException();
    return img.getPixelColor(x / multiplier, y / multiplier);
  }

  @Override
  public int getWidth() {
    return multiplier * img.getWidth();
  }

  @Override
  public int getHeight() {
    return multiplier * img.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1 + img.getNumLayers();
  }
}
