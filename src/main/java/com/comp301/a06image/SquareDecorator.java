package com.comp301.a06image;

import java.awt.*;

public class SquareDecorator implements Image {

  private Image img;
  private int squareX;
  private int squareY;
  private int squareSize;
  private Color color;

  public SquareDecorator(Image image, int squareX, int squareY, int squareSize, Color color) {
    if (image == null || squareSize < 0) {
      throw new IllegalArgumentException();
    }
    this.img = image;
    this.squareX = squareX;
    this.squareY = squareY;
    this.squareSize = squareSize;
    this.color = color;
  }

  @Override
  public Color getPixelColor(int x, int y) {
    if (x < (squareX + squareSize)
        && x >= (squareX)
        && y < (squareY + squareSize)
        && y >= (squareY)) {
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
