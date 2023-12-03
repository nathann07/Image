package com.comp301.a06image;

import java.awt.*;

public class CircleDecorator implements Image {

  private Image img;
  private int cx;
  private int cy;
  private int radius;
  private Color color;

  public CircleDecorator(Image image, int cx, int cy, int radius, Color color) {
    if (image == null || radius < 0) {
      throw new IllegalArgumentException();
    }
    this.img = image;
    this.cx = cx;
    this.cy = cy;
    this.radius = radius;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (Math.sqrt(Math.pow((x - cx), 2) + Math.pow((y - cy), 2)) < radius) {
      return this.color;
    }
    return img.getPixelColor(x, y);
  }

  @Override
  public int getWidth() {
    return img.getWidth();
  }

  @Override
  public int getHeight() {
    return img.getHeight();
  }

  @Override
  public int getNumLayers() {
    return 1 + img.getNumLayers();
  }
}
