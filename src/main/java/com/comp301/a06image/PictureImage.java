package com.comp301.a06image;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PictureImage implements Image {

  private BufferedImage img;

  public PictureImage(String pathname) throws IOException {
    this.img = null;
    File file = new File(pathname);
    if (file == null) throw new IllegalArgumentException();
    img = ImageIO.read(file);
  }

  @Override
  public Color getPixelColor(int x, int y) {
    Color c = new Color(img.getRGB(x, y));
    return c;
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
    return 1;
  }
}
